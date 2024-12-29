package com.developersuraj.OTutorBot.service;

import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NewUserService {

    @Autowired
    private UserRepository userRepository;

    public void saveNewEntity(Users users){

        try {
            userRepository.save(users);
        }
        catch (Exception e){

            log.info("Error occur while creating user "+e);

        }

    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public Users findByUserEmail(String email){
        return userRepository.findByUserEmail(email);
    }

}
