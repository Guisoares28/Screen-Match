package com.example.screenMatch.Models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodeos(@JsonAlias("Title") String titulo,
						     @JsonAlias("Released") String lancamento,
						     @JsonAlias("Episode") String episodeo,
						     @JsonAlias("imdbRating") String avaliacao) {

}
