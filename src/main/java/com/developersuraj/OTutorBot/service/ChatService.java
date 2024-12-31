package com.developersuraj.OTutorBot.service;

import com.developersuraj.OTutorBot.entity.ChatEntity;
import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private NewUserService userService;


    @Transactional
    public void saveData(ChatEntity chatEntity ,  String userEmail){

        try {

            Users users = userService.findByUserEmail(userEmail);
            ChatEntity chat = chatRepository.save(chatEntity);
            users.getChatEntities().add(chat);
            userService.saveEntity(users);

        }
        catch (Exception e){

            throw new RuntimeException(e);

        }

    }

}
