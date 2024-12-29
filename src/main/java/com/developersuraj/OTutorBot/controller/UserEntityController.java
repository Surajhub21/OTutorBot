package com.developersuraj.OTutorBot.controller;

import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserEntityController {

    @Autowired
    private NewUserService userService;

    //Create/Store Chat with AI
    @GetMapping
    public Users userDataGet(){

        // Retrieve the currently authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userEmail = authentication.getName(); // Get the username of the authenticated user

        return userService.findByUserEmail(userEmail);

    }
}
