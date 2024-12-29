package com.developersuraj.OTutorBot.service;

import com.developersuraj.OTutorBot.entity.QuestionAnswerPOJo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class GeminiResponseService {
    //Access APIs and URL from local environment
    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    private final WebClient webClient;

    public GeminiResponseService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public QuestionAnswerPOJo getAnswer(String question){
        //The Format Gemini Get response
//        {
//            "contents": [{
//                  "parts":[
//                      {"text": "Explain how AI works"}
//                   ]
//             }]
//        }
        Map<String , Object> requestBody = Map.of(
                "contents" , new Object[] {
                        Map.of("parts" , new Object[]{
                                Map.of("text" , question)
                        })
                }
        );

        //Make API call
        QuestionAnswerPOJo response = webClient.post()
                .uri(geminiApiUrl)
                .header("Content-Type" , "application/json")
                .bodyValue(requestBody)
                .retrieve() //Retrieve execute the request and expect a response
                .bodyToMono(QuestionAnswerPOJo.class) //Reactive wrapper that is String
                .block();

        //return response
        return response;
    }

    public QuestionAnswerPOJo getAnswer(String question , int noOfQuestion){

        String format = "{\n" +
                "\n" +
                "  \"topic\": \"\",\n" +
                "\n" +
                "  \"questions\": [\n" +
                "\n" +
                "    {\n" +
                "\n" +
                "      \"text\": \"question1\",\n" +
                "\n" +
                "      \"choices\": [\"option a\", \"option b\", \"op c\", \"opiton d\"]\n" +
                "\n" +
                "    },\n" +
                "\n" +
                "    {\n" +
                "\n" +
                "      \"text\": \"Question 2\",\n" +
                "\n" +
                "      \"choices\": [\"options\", \"option b\", \"option c\", \"option d\"]\n" +
                "    }\n" +
                "\n" +
                "  ]\n" +
                "\n" +
                "}";

        Map<String , Object> requestBody = Map.of(
                "contents" , new Object[] {
                        Map.of("parts" , new Object[]{
                                Map.of("text" , "give me "+noOfQuestion+" questions on topic " +question+" in this format"+format)
                        })
                }
        );

        //Make API call
        QuestionAnswerPOJo response = webClient.post()
                .uri(geminiApiUrl)
                .header("Content-Type" , "application/json")
                .bodyValue(requestBody)
                .retrieve() //Retrieve execute the request and expect a response
                .bodyToMono(QuestionAnswerPOJo.class) //Reactive wrapper that is String
                .block();

        //return response
        return response;
    }
}
