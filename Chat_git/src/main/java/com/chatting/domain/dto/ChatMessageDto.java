package com.chatting.domain.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chatMessage")
public class ChatMessageDto {

    // 메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK
    }

    private MessageType type; // 메시지 타입
    private String chatId;
    private String roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지

    private LocalDateTime createdAt;
}
