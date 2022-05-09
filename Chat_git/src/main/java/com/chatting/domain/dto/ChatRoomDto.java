package com.chatting.domain.dto;

import com.chatting.domain.Entity.ChatRoom;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatRoomDto {

    private String name;

    public ChatRoom toEntity(){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        chatRoom.setCreatedAt(LocalDateTime.now());
        return chatRoom;
    }
}
