package com.chat.domain.repository;

import com.chat.domain.model.ChatRoom;
import com.chat.domain.model.Chatting;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChattingRepository extends MongoRepository<ChatRoom, String> {

    List<ChatRoom> findAllByOrOrderByRoomIdDesc();

}
