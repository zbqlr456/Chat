package com.ssafy.backend_chat.domain.dto;

import com.ssafy.backend_chat.domain.entity.ChatMessage;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chatMessage")
public class ChatMessageDto {

    private String roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지

    private LocalDateTime createdAt;

    public ChatMessage toEntity(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRoomId(roomId);
        chatMessage.setSender(sender);
        chatMessage.setMessage(message);
        chatMessage.setCreatedAt(LocalDateTime.now());
        return chatMessage;
    }
}
