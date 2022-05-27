package com.ssafy.backend_chat.controller;

import com.ssafy.backend_chat.domain.dto.ChatMessageDto;
import com.ssafy.backend_chat.domain.entity.ChatMessage;
import com.ssafy.backend_chat.domain.repository.ChatMessageRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "채팅 메세지")
@RequiredArgsConstructor
@RestController
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatMessageRepository chatMessageRepository;

    @MessageMapping("/chatapi/message") // 메세지 보낼때 컨트롤러가 받아줌.
    public void message(ChatMessageDto message) {
//        System.out.println(message);
        chatMessageRepository.save(message.toEntity());
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

//    @GetMapping("/chatapi/messages/{roomId}")
//    @ResponseBody
//    @ApiOperation(value = "채팅방 채팅내역 전체 조회")
//    public List<ChatMessage> roomInfo(@PathVariable String roomId) {
//        return chatMessageRepository.findByRoomIdOrderByCreatedAtDesc(roomId);
//    }

    @GetMapping("/chatapi/messages/{roomId}")
    @ResponseBody
    @ApiOperation(value = "채팅방 채팅내역 전체 조회")
    public List<ChatMessage> roomInfo(@PathVariable String roomId, @RequestParam(value="pageNo")int pageNo) {
//        System.out.println("roomId =" + roomId + " - page =" + pageNo);
        PageRequest pageRequest = PageRequest.of(pageNo, 25);
        Page<ChatMessage> page = chatMessageRepository.findByRoomIdOrderByCreatedAtDesc(roomId, pageRequest);
        List<ChatMessage> rep = page.getContent();
//        System.out.println(rep);
        return rep;
    }
}