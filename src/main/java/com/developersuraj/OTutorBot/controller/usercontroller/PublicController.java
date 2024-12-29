package com.developersuraj.OTutorBot.controller.usercontroller;

import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.repository.UserRepository;
import com.developersuraj.OTutorBot.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/add")
public class PublicController {

    @Autowired
    private NewUserService userService;

    @Autowired
    private UserRepository userRepository;

    //Accessible publicly means anyone add userEntity

    @GetMapping
    public ResponseEntity<List<Users>> allUsers(){

        try {
            List<Users> allUser = userService.getAll();
            return new ResponseEntity<>(allUser , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping
    public ResponseEntity<String> createNewUser(@RequestBody Users users){

        if (userRepository.findByUserEmail(users.getUserEmail()) != null) {
            return new ResponseEntity<>("Email Already in use" , HttpStatus.BAD_REQUEST);
        }

        try {

            userService.saveNewEntity(users);
            return  new ResponseEntity<>(users.getUserName() , HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return  new ResponseEntity<>("Some Error Occur during creation" , HttpStatus.BAD_REQUEST);
        }

    }
}
