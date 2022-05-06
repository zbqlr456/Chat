package com.chat.domain.service;

import com.chat.domain.model.ChatRoom;
import com.chat.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAllRooms(){
        List<ChatRoom> rooms = chatRoomRepository.findAllByOrderByRoodIdDesc();
        return rooms;
    }

    public Optional<ChatRoom> findRoomById(String roomId){
        Optional<ChatRoom> getRoom = chatRoomRepository.findById(roomId);
        return getRoom;
    }

}