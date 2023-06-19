package com.example.securityDemo.service;

import com.google.gson.Gson;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static String convertToJson(Object object) {
        return gson.toJson(object);
    }

    public static <T> T convertFromJson(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }
}