package com.developersuraj.OTutorBot.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@Data
public class Users {

    @Id
    private ObjectId id;
    @NonNull
    @Indexed(unique = true , background = true)
    private String userEmail;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    //User Activity store
    @DBRef
    private ArrayList<ChatEntity> chatEntities = new ArrayList<>();

}
