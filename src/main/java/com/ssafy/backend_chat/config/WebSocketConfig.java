package com.ssafy.backend_chat.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // publisher(게시자)가 message를 생성해 topic에 전달하면
    // subscriber(구독자)가 message를 수신한다.

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub"); // 메모리 기반 메세지 브로커가 해당 api를 구독하고 있는 클라이언트에게 메세지 전달
        config.setApplicationDestinationPrefixes("/pub"); // 서버에서 클라이언트로부터 메세지를 받을 api의 prefix 설정
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*") // 모든 API 연결 가능
                .withSockJS();
    }

}
