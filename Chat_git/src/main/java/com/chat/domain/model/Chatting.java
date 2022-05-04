package com.chat.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "chatting")
@ToString
@Builder
@Getter
@Setter
public class Chatting {

    @Id
    private ObjectId id;

    private long senderName;

    private String sendContent;


}
