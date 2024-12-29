package com.developersuraj.OTutorBot.service;

import com.developersuraj.OTutorBot.entity.Users;
import com.developersuraj.OTutorBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByUserEmail(email);

        if(users != null){
            //
            UserDetails userDetails = User.builder()
                    .username(users.getUserEmail())
                    .password(users.getPassword())
                    .build();

            return userDetails;
        }

        throw new UsernameNotFoundException("Email not found :- " + email);
    }
}
