package com.example.screenMatch.principal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.example.screenMatch.Models.DadosEpisodeos;
import com.example.screenMatch.Models.DadosSerie;
import com.example.screenMatch.Models.DadosTemporadas;
import com.example.screenMatch.Models.Episodio;
import com.example.screenMatch.Service.ConsumoAPI;
import com.example.screenMatch.Service.ConverteDados;

public class Principal {
	public static final String ENDERECO = "https://www.omdbapi.com/?t=";
	public static final String API_KEY = "&apikey=8be28ed2";
	private Scanner scanner = new Scanner(System.in);
	private List<DadosSerie> seriesPesquisadas = new ArrayList<>();
	public void exibeMenu() throws UnsupportedEncodingException {
		Integer resposta = 0;
		while (resposta != 3) {
			System.out.println("\n********OPÇÕES********");
			System.out.println("(1). Pesquisar Series ");
			System.out.println("(2). Series Pesquisadas ");
			System.out.println("(3). Sair ");
			System.out.println("***************************");
			System.out.println("\nQual opção deseja: ");
			resposta = scanner.nextInt();

			switch (resposta) {
				case 1:
					pesquisarSerie();
					break;
				case 2:
					mostrarSeriesPesquisadas();
					break;
			}
		}
	}

	private void mostrarSeriesPesquisadas() {
		seriesPesquisadas.stream()
				.forEach(System.out::println);
	}

	private void pesquisarSerie() {
		scanner.nextLine();
		System.out.println("Qual serie deseja pesquisar: ");
		String serie = scanner.nextLine();
		String serieEncoder = "";
		try {
			serieEncoder = URLEncoder.encode(serie, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		ConsumoAPI consumoApi = new ConsumoAPI();
		ConverteDados converteDados = new ConverteDados();
		String json = consumoApi.obterDados(ENDERECO + serieEncoder + API_KEY);
		DadosSerie dadosSerie = converteDados.converteDados(json, DadosSerie.class);
		seriesPesquisadas.add(dadosSerie);
		System.out.println(dadosSerie);
	}
}
