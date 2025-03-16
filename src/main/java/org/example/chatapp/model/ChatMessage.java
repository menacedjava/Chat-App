package org.example.chatapp.model;

public class ChatMessage {
    private String sender;
    private String content;
    private String timestamp;

    public ChatMessage(String sender, String content, String timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }
}
