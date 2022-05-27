package com.ssafy.backend_chat.domain.entity;

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

    private Long boardId;

    private String image;

    private LocalDateTime createdAt;

    private boolean isEnd;
}
