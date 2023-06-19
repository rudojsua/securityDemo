package com.example.securityDemo.controller;

import com.example.securityDemo.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
 

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    //    this.chatMessages = new ArrayList<>(); // Добавляем пустой список сообщений чата

    }

    @PostMapping("/chat")
    public String sendMessage(@RequestParam("message") String message, Model model) {
        // Отправить сообщение на обработку
        String response = chatService.processMessage(message);
        // Получить текущие сообщения чата из модели
        List<String> chatMessages = (List<String>) model.getAttribute("chatMessages");
        if (chatMessages == null) {
            chatMessages = new ArrayList<>();
        }
        // Добавить новое сообщение в список
        chatMessages.add(message);

        // Обновить модель с обновленными данными
        model.addAttribute("chatMessages", chatMessages);
        model.addAttribute("response", response);

        return "chat-page";
    }
}
