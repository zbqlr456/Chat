package com.chat.controller;

import com.chat.domain.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    /**
     * ENTER이면 입장하셨습니다 전송 or TALK이면 입력한 채팅 전송
     *
     * @param message
     */
    @MessageMapping("/chat/message")
    public void message(ChatDto message) {
        if (ChatDto.MessageType.ENTER.equals(message.getType()))
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}