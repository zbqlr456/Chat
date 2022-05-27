package com.ssafy.backend_chat.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chatMessage")
public class ChatMessage {

    @Id
    private String chatId;
    private String roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지

    private LocalDateTime createdAt;
}
