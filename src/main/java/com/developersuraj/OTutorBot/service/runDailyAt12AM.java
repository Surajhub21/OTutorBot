package com.developersuraj.OTutorBot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class runDailyAt12AM {

    @Value("${GOOGLE_SCRIPT_FOR12PM}")
    private String googleScriptURL;

    public final WebClient webClient;

    public runDailyAt12AM(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public void runAt12AM(){
        try {

            webClient.get()
                    .uri(googleScriptURL)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }
        catch (Exception e){
            log.info("Error duo to some (RunDailyAt12PM) " + e);
        }
    }

}
