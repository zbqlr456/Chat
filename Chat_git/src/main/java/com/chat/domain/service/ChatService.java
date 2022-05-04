package com.chat.domain.service;

import com.chat.domain.dto.ChatRoom;
import com.chat.domain.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAllRooms(){
        List<ChatRoom> rooms = chatRoomRepository.findAllRoom();
        return rooms;
    }

    public ChatRoom createRoom(String name){
        ChatRoom newRoom = chatRoomRepository.createChatRoom(name);
        return newRoom;
    }

    public ChatRoom findRoomById(String roomId){
        ChatRoom getRoom = chatRoomRepository.findRoomById(roomId);
        return getRoom;
    }

}