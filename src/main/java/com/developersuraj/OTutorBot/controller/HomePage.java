package com.developersuraj.OTutorBot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    public String home(){
        return "index";
    }

    @GetMapping("/req/txt")
    public String req(){
        return "Connected!";
    }

}
