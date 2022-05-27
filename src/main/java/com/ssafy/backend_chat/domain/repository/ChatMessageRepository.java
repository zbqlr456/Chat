package com.ssafy.backend_chat.domain.repository;

import com.ssafy.backend_chat.domain.entity.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    Page<ChatMessage> findByRoomIdOrderByCreatedAtDesc(String roomId, PageRequest pageRequest);

//    List<ChatMessage> findFirstLimitByRoomIdOrderByCreatedAtDesc(String roomId, int limit);
    List<ChatMessage> findByRoomId(String roomId);

}