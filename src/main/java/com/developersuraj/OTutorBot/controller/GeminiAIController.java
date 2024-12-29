package com.developersuraj.OTutorBot.controller;

import com.developersuraj.OTutorBot.entity.QuestionAnswerPOJo;
import com.developersuraj.OTutorBot.service.GeminiResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/user/ai")
public class GeminiAIController {

    private final GeminiResponseService geminiResponseService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String , String> payload){

        try{
            //get Question
            String question = payload.get("question");
            //Getting Answer
            QuestionAnswerPOJo answer = geminiResponseService.getAnswer(question);
            //Return the answer
            return new ResponseEntity<>(answer.candidates.get(0).content.parts.get(0).text , HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>("Error occur duo to " + e , HttpStatus.BAD_REQUEST);
        }
    }
}
