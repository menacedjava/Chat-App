package org.example.chatapp.controller;

import org.example.chatapp.model.ChatMessage;
import org.example.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody ChatMessage message) {
        chatService.saveMessage(message);
    }

    @GetMapping("/messages")
    public List<ChatMessage> getAllMessages() {
        return chatService.getMessages();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return """
                Chat server is running!
                Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!Chat server is running!
                """;
    }

}
