package org.example.chatapp.service;

import org.example.chatapp.model.Message;
import org.example.chatapp.repo.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getRecentMessages() {
        return messageRepository.findTop20ByOrderByTimestampDesc();
    }



}
