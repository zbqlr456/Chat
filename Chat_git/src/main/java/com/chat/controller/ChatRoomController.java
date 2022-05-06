package com.chat.controller;

import com.chat.domain.dto.ChatRoomDto;
import com.chat.domain.model.ChatRoom;
import com.chat.domain.repository.ChatRoomRepository;
import com.chat.domain.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;
    private final ChatRoomRepository chatRoomRepository;

    /**
     * View 모델 생성
     *
     * @param model
     * @return
     */
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    /**
     * 채팅방 전제 조회
     *
     * @return
     */
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomService.findAllRooms();
    }

    /**
     * 채팅방 생성
     *
     * @param chatRoomDto
     * @return
     */
    @PostMapping("/room")
    public void createRoom(@RequestBody ChatRoomDto chatRoomDto) {
        chatRoomRepository.save(chatRoomDto.toEntity());
    }

    /**
     * 채팅방 입장 모델 생성
     *
     * @param model
     * @param roomId
     * @return
     */
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomDetail";
    }

    /**
     * 채팅방 입장
     *
     * @param roomId
     * @return
     */
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public Optional<ChatRoom> roomInfo(@PathVariable String roomId) {
        return chatRoomService.findRoomById(roomId);
    }
}

