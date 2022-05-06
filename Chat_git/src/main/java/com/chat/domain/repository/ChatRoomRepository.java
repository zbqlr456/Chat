package com.chat.domain.repository;

import com.chat.domain.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {


    List<ChatRoom> findAllByOrderByRoodIdDesc();
}
