package com.ssafy.backend_chat.domain.dto;

import com.ssafy.backend_chat.domain.entity.ChatRoom;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatRoomDto {

    private String name;
    private Long boardId;
    private String image;

    public ChatRoom toEntity() {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        chatRoom.setBoardId(boardId);
        chatRoom.setImage(image);
        chatRoom.setCreatedAt(LocalDateTime.now());
        return chatRoom;
    }
}