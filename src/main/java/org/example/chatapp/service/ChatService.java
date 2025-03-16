package org.example.chatapp.service;

import org.example.chatapp.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChatService {
    private final List<ChatMessage> messageList = new ArrayList<>();

    public void saveMessage(ChatMessage message) {
        messageList.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messageList;
    }
}
