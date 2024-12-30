package com.developersuraj.OTutorBot.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class ChatEntity {

    @Id
    private ObjectId id;
    private String response;
    private String question;

}
