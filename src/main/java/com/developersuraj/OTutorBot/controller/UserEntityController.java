package com.developersuraj.OTutorBot.controller;

import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserEntityController {

    @Autowired
    private NewUserService userService;

    //Create/Store Chat with AI
    @GetMapping("{userEmail}")
    public ResponseEntity<Users> userDataGet(@PathVariable String userEmail){

        // Retrieve the user's details
        Users user = userService.findByUserEmail(userEmail);

        return new ResponseEntity<>(user , HttpStatus.OK);

    }
}
