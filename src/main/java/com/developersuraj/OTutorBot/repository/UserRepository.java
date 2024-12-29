package com.developersuraj.OTutorBot.repository;

import com.developersuraj.OTutorBot.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, Object> {

    Users findByUserEmail(String userEmail);

}
