package org.example.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TypingController {

    @MessageMapping("/typing")
    @SendTo("/topic/typing")
    public String handleTyping(String username) {
        return username + " is typing...";
    }
}
