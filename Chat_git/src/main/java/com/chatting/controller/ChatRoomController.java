package com.chatting.controller;

import com.chatting.domain.Entity.ChatMessage;
import com.chatting.domain.dto.ChatRoomDto;
import com.chatting.domain.Entity.ChatRoom;
import com.chatting.domain.repository.ChatMessageRepository;
import com.chatting.domain.repository.ChatRoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "채팅방")
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    @GetMapping("/rooms")
    @ResponseBody
    @ApiOperation(value = "채팅방 전체 조회")
    public List<ChatRoom> room() {
        return chatRoomRepository.findAllBy();
    }

    @PostMapping("/room")
    @ApiOperation(value = "채팅방 개설")
    public void createRoom(@RequestBody ChatRoomDto chatRoomDto) {
        chatRoomRepository.save(chatRoomDto.toEntity());
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    @ApiOperation(value = "채팅방 채팅내역 전체 조회")
    public List<ChatMessage> roomInfo(@PathVariable String roomId) {
        return chatMessageRepository.findByRoomIdOrderByCreatedAtDesc(roomId);
    }

}

//package com.chatting.controller;
//
//import com.chatting.domain.model.ChatRoom;
//import com.chatting.domain.repository.ChatRoomRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collection;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/chat")
//public class ChatRoomController {
//
//    private final ChatRoomRepository chatRoomRepository;
//
//    @GetMapping("/room")
//    public String rooms(Model model) {
//        return "/chat/room";
//    }
//
//    @GetMapping("/rooms")
//    @ResponseBody
//    public List<ChatRoom> room() {
//        return chatRoomRepository.findAllRoom();
//    }
//
//    @PostMapping("/room")
//    @ResponseBody
//    public ChatRoom createRoom(@RequestParam String name) {
//        return chatRoomRepository.createChatRoom(name);
//    }
//
//    @GetMapping("/room/enter/{roomId}")
//    public String roomDetail(Model model, @PathVariable String roomId) {
//        model.addAttribute("roomId", roomId);
//        return "/chat/roomdetail";
//    }
//
//    @GetMapping("/room/{roomId}")
//    @ResponseBody
//    public ChatRoom roomInfo(@PathVariable String roomId) {
//        return chatRoomRepository.findRoomById(roomId);
//    }
//}

