package com.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

// http://localhost:8082/swagger-ui/index.html
// http://localhost:8082/chat/room

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

}
