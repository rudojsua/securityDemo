package com.example.securityDemo.service;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatGptClient  chatGptClient;

    public ChatService(ChatGptClient chatGptClient) {
        this.chatGptClient = chatGptClient;
    }


    public String processMessage(String message){
        String response =chatGptClient.sendMessage(message);

        return response;
    }
}
