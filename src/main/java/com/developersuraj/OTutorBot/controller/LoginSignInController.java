package com.developersuraj.OTutorBot.controller;

import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/req")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginSignInController {

    @Autowired
    private NewUserService userService;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<Users> createUser(@RequestBody Users users){

        if(userService.findByUserEmail(users.getUserEmail()) != null){

            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);

        }
        if(userService.saveNewEntity(users)){

            return new ResponseEntity<>(users , HttpStatus.OK);

        }
        else {

            return new ResponseEntity<>(users , HttpStatus.NO_CONTENT);

        }

    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String , String> payload){

        Users users1 = userService.findByUserEmail(payload.get("userEmail"));

        if(users1 != null) {
            if (passwordEncoder.matches(payload.get("password") , users1.getPassword())) {

                return new ResponseEntity<>(users1.getUserName() , HttpStatus.OK);

            }else {
                return new ResponseEntity<>("Password Not matched", HttpStatus.BAD_REQUEST);
            }
        }
        else {

            return new ResponseEntity<>("User Not Exists!", HttpStatus.NOT_FOUND);

        }

    }


    @GetMapping("/txt")
    public String connected(){
        return "Connected User";
    }



}
