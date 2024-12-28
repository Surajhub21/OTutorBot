package com.developersuraj.OTutorBot.service;

import com.developersuraj.OTutorBot.entity.MessageResponseFromScript;
import com.developersuraj.OTutorBot.entity.QuestionPOJO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ScriptFormCreationService {

    @Value("${console.google.access.token}")
    public String accessToken;

    @Value("${google.app.script.url}")
    public String scriptURL;

    public final WebClient webClient;

    public ScriptFormCreationService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public MessageResponseFromScript getFormURL(QuestionPOJO questionPOJO){

        String firstResponse = webClient.post()
                .uri(scriptURL)
                .header("Content-Type" , "application/json")
                .header("Authorization" , "Bearer "+accessToken)
                .bodyValue(questionPOJO)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String storeResponse = extractRedirectUrl(firstResponse);

        MessageResponseFromScript secondResponse = webClient.get()
                .uri(storeResponse)
                .header("Content-Type" , "application/json")
                .retrieve()
                .bodyToMono(MessageResponseFromScript.class)
                .block();

        return secondResponse;

    }

    public String extractRedirectUrl(String htmlResponse) {
        // Parse the HTML response
        Document doc = Jsoup.parse(htmlResponse);

        // Find the <a> tag
        Element linkElement = doc.selectFirst("a");

        if (linkElement != null) {
            // Get the href attribute
            return linkElement.attr("href");
        } else {
            return "NULL";
        }
    }
}