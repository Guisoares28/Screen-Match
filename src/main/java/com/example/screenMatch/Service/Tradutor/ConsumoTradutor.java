package com.example.screenMatch.Service.Tradutor;

import com.example.screenMatch.Service.ConsumoAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okio.Utf8;

import java.net.URLEncoder;

public class ConsumoTradutor {
    ConsumoAPI consumo =  new ConsumoAPI();
    ObjectMapper mapper = new ObjectMapper();

    public String consumoTradutor(String text){
        String texto = URLEncoder.encode(text);
        String langpair = URLEncoder.encode("en|pt-br");
        String url = "https://api.mymemory.translated.net/get?q="+texto+"!&langpair="+langpair;
        String json = consumo.obterDados(url);

        ResponseTraducao traducao;
        try{
            traducao = mapper.readValue(json,ResponseTraducao.class);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return traducao.responseData().traducao();
    }


}
