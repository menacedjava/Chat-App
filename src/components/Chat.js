import React, { useState, useEffect } from "react";

const Chat = () => {
    const [socket, setSocket] = useState(null);
    const [messages, setMessages] = useState([]);
    const [message, setMessage] = useState("");
    const [username, setUsername] = useState("");

    useEffect(() => {
        const newSocket = new WebSocket("ws://localhost:8080/chat");
        newSocket.onopen = () => console.log("WebSocket connected");
        newSocket.onmessage = (event) => {
            setMessages((prev) => [...prev, JSON.parse(event.data)]);
        };
        setSocket(newSocket);

        return () => newSocket.close();
    }, []);

    const sendMessage = () => {
        if (socket && message.trim() !== "") {
            const chatMessage = { username, content: message };
            socket.send(JSON.stringify(chatMessage));
            setMessage("");
        }
    };

    return (
        <div>
            {/*<h2>Chat</h2>*/}
            {/*<input*/}
            {/*    type="text"*/}
            {/*    placeholder="Enter username"*/}
            {/*    value={username}*/}
            {/*    onChange={(e) => setUsername(e.target.value)}*/}
            {/*/>*/}
            {/*<div style={{ border: "1px solid black", height: "300px", overflowY: "scroll" }}>*/}
            {/*    {messages.map((msg, index) => (*/}
            {/*        <p key={index}>*/}
            {/*            <strong>{msg.username}:</strong> {msg.content}*/}
            {/*        </p>*/}
            {/*    ))}*/}
            {/*</div>*/}
            <input
                type="text"
                placeholder="Enter message"
                value={message}
                onChange={(e) => setMessage(e.target.value)}
            />
            <button onClick={sendMessage}>Send</button>
        </div>
    );
};

export default Chat;
