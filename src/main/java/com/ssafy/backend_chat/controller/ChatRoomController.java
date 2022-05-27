package com.ssafy.backend_chat.controller;

import com.ssafy.backend_chat.domain.dto.ChatRoomDto;
import com.ssafy.backend_chat.domain.dto.ChatRoomsDto;
import com.ssafy.backend_chat.domain.entity.ChatRoom;
import com.ssafy.backend_chat.domain.repository.ChatRoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "채팅방")
@RequiredArgsConstructor
@RestController
@RequestMapping("/chatapi")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;

    @PostMapping("/rooms")
    @ResponseBody
    @ApiOperation(value = "내가 속한 채팅방 전체 조회")
    public List<ChatRoom> room(@RequestBody ChatRoomsDto chatRoomsDto) {
//        return chatRoomRepository.findAllBy(Sort.by(Sort.Direction.DESC,"createdAt"));
        System.out.println("boards = " + chatRoomsDto);
        List<Long> boards = chatRoomsDto.getBoards();
        System.out.println("방찾는거 체크" + chatRoomRepository.findByBoardIdInOrderByCreatedAtDesc(boards));
        return chatRoomRepository.findByBoardIdInOrderByCreatedAtDesc(boards);

    }

    @PostMapping("/room")
    @ApiOperation(value = "채팅방 개설")
    public void createRoom(@RequestBody ChatRoomDto chatRoomDto) {
        System.out.println(chatRoomDto);
        chatRoomRepository.save(chatRoomDto.toEntity());
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    @ApiOperation(value = "채팅방 이름 조회")
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findByRoomId(roomId);
    }

    @GetMapping("/board/{boardId}")
    @ApiOperation(value = "게시판 ID로 채팅방 ID 조회")
    public String getRoomId(@PathVariable("boardId") Long boardId){
        ChatRoom chatRoom = chatRoomRepository.findTopByBoardIdOrderByCreatedAt(boardId);
        return chatRoom.getRoomId();
    }

    @PatchMapping("/room/{boardId}")
    @ApiOperation(value = "게시글 종료 or 삭제시 채팅방 끝남")
    public void roomIsEnd(@PathVariable Long boardId){
        ChatRoom chatRoom = chatRoomRepository.findTopByBoardIdOrderByCreatedAt(boardId);
//        System.out.println(chatRoom);
        chatRoom.setEnd(true);
        chatRoomRepository.save(chatRoom);
    }

}
