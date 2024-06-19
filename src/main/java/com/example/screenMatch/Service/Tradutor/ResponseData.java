package com.example.screenMatch.Service.Tradutor;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseData(@JsonAlias(value = "translatedText") String traducao) {
}
