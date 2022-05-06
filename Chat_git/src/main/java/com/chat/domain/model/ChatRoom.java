package com.chat.domain.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "chatRoom")
public class ChatRoom {

    @Id
    private ObjectId roomId;

    private String roomName;

}
