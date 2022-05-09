package com.chatting.domain.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chatRoom")
public class ChatRoom {

    @Id
    private String roomId;

    private String name;

    private LocalDateTime createdAt;

}

//package com.chatting.domain.model;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.UUID;
//
//@Getter
//@Setter
//public class ChatRoom {
//    private String roomId;
//    private String name;
//
//    public static ChatRoom create(String name) {
//        ChatRoom chatRoom = new ChatRoom();
//        chatRoom.roomId = UUID.randomUUID().toString();
//        chatRoom.name = name;
//        return chatRoom;
//    }
//}

