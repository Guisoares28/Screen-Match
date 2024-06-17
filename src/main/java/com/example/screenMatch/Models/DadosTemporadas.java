package com.example.screenMatch.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadas(@JsonAlias("Title") String titulo,
							  @JsonAlias("Season") Integer temporada,
							  @JsonAlias("Episodes")List<DadosEpisodeos> episodios) {

}
