package com.chatting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChattingApplication {

    // http://localhost:8081/swagger-ui/index.html
    // http://localhost:8081/chat/room

    public static void main(String[] args) {
        SpringApplication.run(ChattingApplication.class, args);
    }

}
