package com.example.screenMatch.Models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {	
	private Integer NumeroTemporada;
	private String titulo;
	private Integer NumeroEpisodio;
	private Double avaliacao;
	private LocalDate lancamento;
	
	public Episodio(Integer numeroTemporada, DadosEpisodeos dados) {
		this.NumeroTemporada = numeroTemporada;
		this.titulo = dados.titulo();
		this.NumeroEpisodio = Integer.parseInt(dados.episodeo());	
		
		try {
			this.avaliacao = Double.valueOf(dados.avaliacao());	
		} catch (NumberFormatException e) {
			
			this.avaliacao = 0.0;		
		}
		
		try {
			this.lancamento = LocalDate.parse(dados.lancamento());
		} catch (DateTimeParseException e) {
			this.lancamento = null;
		}
	}
	
	public Integer getNumeroTemporada() {
		return NumeroTemporada;
	}
	public void setTemporada(Integer temporada) {
		this.NumeroTemporada = temporada;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getNumeroEpisodio() {
		return NumeroEpisodio;
	}
	public void setNumeroEpisodio(Integer numeroEpisodio) {
		NumeroEpisodio = numeroEpisodio;
	}
	public Double getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public LocalDate getLancamento() {
		return lancamento;
	}
	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public String toString() {
		return "temporada: " + NumeroTemporada 
				+" Titulo: " + titulo 
				+ " NumeroEpisodio: " + NumeroEpisodio
				+ " Avaliacao: " + avaliacao 
				+ " Lancamento: " + lancamento;
	}
	
	
	
	
}
