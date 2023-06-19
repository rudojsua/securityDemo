package com.example.securityDemo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ChatGptClient {

    private final String apiKey;
    private final String apiUrl;

    public ChatGptClient(String apiKey, String apiUrl) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    public String sendMessage(String message) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(buildRequestBody(message)))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while sending the message.";
        }
    }

    private String buildRequestBody(String message) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("message", message);
        requestBody.put("model", "gpt-3.5-turbo");
        // Дополнительные параметры или настройки API запроса, если необходимо
        // requestBody.put("param_name", param_value);

        return JsonUtils.convertToJson(requestBody);
    }
}