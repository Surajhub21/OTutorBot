package com.developersuraj.OTutorBot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class HomePage {

    @GetMapping("/")
    public String login(){
        return "home";
    }

    @GetMapping("/user")
    public String home(){
        return "index";
    }

}
