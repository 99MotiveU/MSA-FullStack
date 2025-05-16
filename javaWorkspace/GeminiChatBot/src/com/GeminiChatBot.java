package com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

public class GeminiChatBot {
    // ✅ API 키는 환경변수에서 가져오는 것이 보안에 좋음
    private static final String API_KEY = "AIzaSyB2ApzJtWhcmnbmEkpgZfOZeJPSVWDWbvY";  
    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent?key=" + API_KEY;

    public static String chatWithGemini(String userMessage) {
        try {
            URL url = new URL(GEMINI_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // ✅ 최신 API에 맞는 요청 데이터 구조
            String requestBody = "{ \"messages\": [{ \"role\": \"user\", \"content\": \"" + userMessage + "\" }] }";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(requestBody.getBytes("UTF-8"));
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 404) {
                return "오류 발생: 404 - API URL이 잘못되었거나, 서비스가 활성화되지 않음.";
            }
            if (responseCode != 200) {
                return "오류 발생: HTTP " + responseCode;
            }

            // 응답 읽기
            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
            }

            // JSON 응답 파싱
            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray candidates = jsonResponse.getAsJsonArray("candidates");
            if (candidates != null && candidates.size() > 0) {
                return candidates.get(0).getAsJsonObject().get("content").getAsString();
            }

            return "응답을 이해할 수 없습니다.";
        } catch (Exception e) {
            e.printStackTrace();
            return "오류 발생: " + e.getMessage();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Gemini AI 챗봇에 메시지를 입력하세요 (exit 입력 시 종료):");

        while (true) {
            System.out.print("사용자: ");
            String userMessage = reader.readLine();
            if (userMessage.equalsIgnoreCase("exit")) {
                System.out.println("챗봇 종료.");
                break;
            }
            String botResponse = chatWithGemini(userMessage);
            System.out.println("Gemini: " + botResponse);
        }
    }
}
