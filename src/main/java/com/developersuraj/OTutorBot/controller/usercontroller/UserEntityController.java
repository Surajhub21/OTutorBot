package com.developersuraj.OTutorBot.controller.usercontroller;

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
    @GetMapping("/{userEmail}_{userPass}")
    public ResponseEntity<Users> getTheUser(@PathVariable String userEmail , @PathVariable String userPass){

        Users users = userService.findByUserEmail(userEmail);

        if(users.getPassword().equals(userPass)){

            return new ResponseEntity<>(users , HttpStatus.OK);

        }else {

            return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);

        }

    }

}
