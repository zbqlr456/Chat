package com.chat.domain.repository;

import com.chat.domain.model.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Chat,String> {
}
