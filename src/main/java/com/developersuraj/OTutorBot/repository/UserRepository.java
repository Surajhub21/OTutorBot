package com.developersuraj.OTutorBot.repository;

import com.developersuraj.OTutorBot.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, ObjectId> {

    Users findByUserEmail(String userEmail);

}
