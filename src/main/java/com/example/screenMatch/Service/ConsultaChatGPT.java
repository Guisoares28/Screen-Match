package com.example.screenMatch.Service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {


    public static String obterTraducao(String texto){
        final String TOKEN = "sk-proj-LTLnNsDAFE2pCIL7bQWBT3BlbkFJj34hgPwCkcaJgNcbfMjH";

        OpenAiService service = new OpenAiService(TOKEN);

        CompletionRequest request = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt("traduze para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var response = service.createCompletion(request);

        return response.getChoices().get(0).getText();
    }

}
