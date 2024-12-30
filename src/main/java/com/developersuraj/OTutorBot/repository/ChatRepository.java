package com.developersuraj.OTutorBot.repository;

import com.developersuraj.OTutorBot.entity.ChatEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<ChatEntity , ObjectId> {

}
