import React, { useState, useEffect } from "react";
import { Client } from "@stomp/stompjs";

const Chat = () => {
    const [client, setClient] = useState(null);
    const [messages, setMessages] = useState([]);
    const [typingMessage, setTypingMessage] = useState("");
    const [message, setMessage] = useState("");

    useEffect(() => {
        const stompClient = new Client({
            brokerURL: "ws://localhost:5757/ws",
            onConnect: () => {
                console.log("Connected to WebSocket");


                stompClient.subscribe("/topic/messages", (msg) => {
                    setMessages((prev) => [...prev, msg.body]);
                });


                stompClient.subscribe("/topic/typing", (msg) => {
                    setTypingMessage(msg.body);
                    setTimeout(() => setTypingMessage(""), 2000); // 2 sec ko‘rinib turadi
                });
            },
        });

        stompClient.activate();
        setClient(stompClient);

        return () => {
            stompClient.deactivate();
        };
    }, []);

    const sendMessage = () => {
        if (client && message.trim() !== "") {
            client.publish({
                destination: "/app/message",
                body: message,
            });
            setMessage("");
        }
    };

    const handleTyping = () => {
        if (client) {
            client.publish({
                destination: "/app/typing",
                body: "User is typing...",
            });
        }
    };

    return (
        <div style={{ width: "400px", margin: "auto", textAlign: "center" }}>
            <h2>Chat App</h2>
            <div style={{ height: "200px", overflowY: "auto", border: "1px solid #ccc", padding: "10px" }}>
                {messages.map((msg, index) => (
                    <p key={index}>{msg}</p>
                ))}
            </div>
            <p style={{ fontStyle: "italic", color: "gray" }}>{typingMessage}</p>
            <input
                type="text"
                value={message}
                onChange={(e) => setMessage(e.target.value)}
                onKeyPress={handleTyping}
                placeholder="Type a message..."
                style={{ width: "80%", padding: "5px" }}
            />
            <button onClick={sendMessage} style={{ marginLeft: "10px" }}>Send</button>
        </div>
    );
};

export default Chat;
