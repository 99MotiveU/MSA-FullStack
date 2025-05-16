package MafiaG;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class ConGemini {
    private static final String GEMINI_API_KEY = "AIzaSyBMbNZD6Q_zmzErjpfK_l9Ti7FMtzYAadA";
    private static final String GEMINI_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-pro:generateContent?key=";

    public static String getResponse(String userPrompt) throws IOException {
        URL url = new URL(GEMINI_URL + GEMINI_API_KEY);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        String jsonInput = "{\n" +
                "  \"contents\": [\n" +
                "    {\n" +
                "      \"parts\": [\n" +
                "        { \"text\": \"" + userPrompt + "\" }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"generationConfig\": {\n" +
                "    \"temperature\": 0.5\n" +
                "  }\n" +
                "}";

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int responseCode = conn.getResponseCode();
        InputStream inputStream = (responseCode >= 200 && responseCode < 300)
                ? conn.getInputStream() : conn.getErrorStream();

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        return extractTextFromResponse(response.toString());
    }

    private static String extractTextFromResponse(String json) {
        int start = json.indexOf("\"text\": \"") + 9;
        int end = json.indexOf("\"", start);
        if (start != -1 && end != -1 && end > start) {
            return json.substring(start, end).replace("\\n", "\n");
        }
        return "ÀÀ´ä ÆÄ½Ì ½ÇÆÐ: " + json;
    }
}