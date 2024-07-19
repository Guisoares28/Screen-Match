package com.example.screenMatch.principal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import com.example.screenMatch.Models.*;
import com.example.screenMatch.Service.ConsumoAPI;
import com.example.screenMatch.Service.ConverteDados;
import com.example.screenMatch.repository.SerieRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Principal {
	public static final String ENDERECO = "https://www.omdbapi.com/?t=";
	public static final String API_KEY = System.getenv("TRADUTOR_APIKEY");
	private Scanner scanner = new Scanner(System.in);
	private ConsumoAPI consumoApi = new ConsumoAPI();
	private ConverteDados converteDados = new ConverteDados();
	private SerieRepository repositorio;

	public Principal(SerieRepository repository) {
		this.repositorio = repository;
	}

	public void exibeMenu() throws UnsupportedEncodingException {
		Integer resposta = 0;
		while (resposta != 3) {
			System.out.println("\n********OPÇÕES********");
			System.out.println("(1). Pesquisar Series ");
			System.out.println("(2). Series Pesquisadas ");
			System.out.println("(3). Pesquisar episodios por Serie ");
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
				case 3:
					mostrarEpisodiosPorserie();
			}
		}
	}

	private void mostrarEpisodiosPorserie() {
		DadosSerie dadosSerie = getDadosSerie();
		List<DadosTemporadas> temporadas =  new ArrayList<>();

		for (int i = 1; i < dadosSerie.totalTemporadas(); i++) {
			String serieTitle = URLEncoder.encode(dadosSerie.titulo(), StandardCharsets.UTF_8);
			String json = consumoApi.obterDados(ENDERECO + serieTitle + "&season=" + i + API_KEY);
			DadosTemporadas newTemporada = converteDados.converteDados(json, DadosTemporadas.class);
			temporadas.add(newTemporada);
		}
		temporadas.forEach(System.out::println);

		}


	private DadosSerie getDadosSerie(){
		scanner.nextLine();
		System.out.println("Qual serie deseja pesquisar: ");
		String serie = scanner.nextLine();
		String serieEncoder = URLEncoder.encode(serie, StandardCharsets.UTF_8);
		String json = consumoApi.obterDados(ENDERECO + serieEncoder + API_KEY);
		DadosSerie dadosSerie = converteDados.converteDados(json, DadosSerie.class);
		return dadosSerie;
	}
	private void mostrarSeriesPesquisadas() {
		List<Serie> series = repositorio.findAll();
		series.stream()
				.sorted(Comparator.comparing(Serie::getAvaliacao))
				.forEach(System.out::println);

	}

	private void pesquisarSerie() {
		DadosSerie DadosSerie = getDadosSerie();
		Serie serie = new Serie(DadosSerie);
		repositorio.save(serie);
		System.out.println(serie);
	}
}
