package com.developersuraj.OTutorBot.controller;

import com.developersuraj.OTutorBot.entity.ChatEntity;
import com.developersuraj.OTutorBot.entity.QuestionAnswerPOJo;
import com.developersuraj.OTutorBot.service.ChatService;
import com.developersuraj.OTutorBot.service.GeminiResponseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/ai")
@CrossOrigin(origins = "http://localhost:5173")
public class GeminiAIController {

    private final GeminiResponseService geminiResponseService;

    private final ChatService chatService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody Map<String , String> payload){

        try{
            //get Question
            String question = payload.get("question");
            String userEmail = payload.get("userEmail");
            //Getting Answer
            QuestionAnswerPOJo answer = geminiResponseService.getAnswer(question);

            if(question != null && answer != null){
                ChatEntity chat = new ChatEntity();
                chat.setQuestion(question);
                chat.setResponse(answer.candidates.get(0).content.parts.get(0).text);
                chatService.saveData(chat , userEmail);
            }
            //Return the answer
            return new ResponseEntity<>(answer.candidates.get(0).content.parts.get(0).text , HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>("Error occur duo to " + e , HttpStatus.BAD_REQUEST);
        }
    }
}
