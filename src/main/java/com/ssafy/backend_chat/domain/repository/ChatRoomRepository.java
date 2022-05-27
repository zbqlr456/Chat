package com.ssafy.backend_chat.domain.repository;


import com.ssafy.backend_chat.domain.entity.ChatRoom;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRoomRepository extends MongoRepository<ChatRoom,String> {

    ChatRoom findTopByBoardIdOrderByCreatedAt(Long boardId);

    List<ChatRoom> findAllBy(Sort createdAt);

    ChatRoom findByRoomId(String roomId);

    List<ChatRoom> findByBoardIdInOrderByCreatedAtDesc(List<Long> boards);
}