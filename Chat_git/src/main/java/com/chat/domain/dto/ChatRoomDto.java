package com.chat.domain.dto;

import com.chat.domain.model.ChatRoom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomDto {

    private String name;

    public ChatRoom toEntity(){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        return chatRoom;
    }

}