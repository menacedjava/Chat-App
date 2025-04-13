package org.example.chatapp.controller;

import org.example.chatapp.model.Message;
import org.example.chatapp.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        return null;
    }

    @MessageMapping("/typing")
    @SendTo("/topic/typing")
    public String userTyping(String username) {
        return username + " is typing...";
    }
    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        return message;
    }

    @MessageMapping("/typing")
    @SendTo("/topic/typing")
    public String handleTyping(String username) {
        return username + " is typing...";
    }}
