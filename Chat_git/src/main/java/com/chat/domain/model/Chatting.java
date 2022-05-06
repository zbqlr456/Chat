package com.chat.domain.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "chatting")
public class Chatting {

    @Id
    private ObjectId id;

    private long senderName;

    private String sendContent;


}
