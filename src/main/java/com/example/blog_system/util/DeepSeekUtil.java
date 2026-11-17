package com.example.blog_system.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DeepSeekUtil {

    // 【极其重要】把你的 API Key 填在这里！保留双引号！
    private static final String API_KEY = "sk-ab08095991d04146940af52589e6cd9a";
    private static final String API_URL = "https://api.deepseek.com/chat/completions";

    public static String askAI(String prompt) {
        try {
            // 1. 创建 RestTemplate 对象
            RestTemplate restTemplate = new RestTemplate();

            // 2. 设置请求头（告诉服务器我要发 JSON，并且带上我的 Key）
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(API_KEY);

            // 3. 构造 JSON 请求体（兼容 Java 8 的拼接大法）
            String requestBody = "{\n" +
                    "    \"model\": \"deepseek-chat\",\n" +
                    "    \"messages\": [\n" +
                    "        {\"role\": \"user\", \"content\": \"" + prompt.replace("\"", "\\\"") + "\"}\n" +
                    "    ],\n" +
                    "    \"stream\": false\n" +
                    "}";

            // 4. 把请求头和请求体打包成一个 HttpEntity
            HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

            // 5. 发送 POST 请求，拿到结果
            ResponseEntity<String> response = restTemplate.postForEntity(API_URL, request, String.class);

            // 返回结果字符串
            return response.getBody();

        } catch (Exception e) {
            return "AI 调用失败: " + e.getMessage();
        }
    }
}