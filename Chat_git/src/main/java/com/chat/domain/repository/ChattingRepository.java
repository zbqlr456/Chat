package com.chat.domain.repository;

import com.chat.domain.model.Chatting;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChattingRepository extends MongoRepository<Chatting, String> {

    Chatting findById(ObjectId id);

}
