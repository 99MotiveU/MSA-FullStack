import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class GeminiApiExample {

    private static final String API_KEY = "AIzaSyDu4nZQpWG3aboH72j6uTlqASjCyfVz8hk"; // ���⿡ API Ű�� �Է��ϼ���
    private static final String MODEL_NAME = "gemini-pro"; // ����� ���� �����ϼ���

    // ���� ������ Gemini ��:
    // "gemini-pro": �Ϲ����� ���� �� (����)
    // "gemini-pro-vision": ��Ƽ��� �Է��� �����ϴ� ���� �� (����) - �̹��� �˻� �� �ؽ�Ʈ ���� ��� ����
    // "gemini-ultra": �ְ� ������ �ڶ��ϴ� ��Ʈ�� �� (����) - ��Ը� ������ ó�� �� ������ �۾��� ����
    // "gemini-nano": �淮ȭ�� �� (����) - �⺻���� �ؽ�Ʈ ���� �� ������ �۾��� ����
    // ��� ����: https://ai.google.dev/pricing

    public static void main(String[] args) {
        String prompt = "�ΰ�����(AI)�� ��� �۵��ϴ��� ������ �ּ���\n" +
		                "������ �������ٴ� �����ϱ� ������ ������ �ּ���.\n" +
		                "������ ������ �߰����ּ���.";

        try {
            String response = callGeminiApi(prompt);
            System.out.println("Response from API: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String callGeminiApi(String prompt) throws Exception {
        String urlString = "https://generativelanguage.googleapis.com/v1beta/models/" + MODEL_NAME + ":generateContent?key=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // JSON ������ �ùٸ��� Ȯ��
        String jsonInputString = String.format(
                "{\"contents\": [{\"parts\": [{\"text\": \"%s\"}]}]}",
                prompt.replace("\n", "\\n")
        );

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) { // �������� ���� �ڵ� 200�� üũ
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                // JSON ���信�� �޽����� ����
                JSONObject jsonResponse = new JSONObject(response.toString());
                if (jsonResponse.has("candidates")) {
                    JSONArray candidates = jsonResponse.getJSONArray("candidates");
                    StringBuilder message = new StringBuilder();
                    for (int i = 0; i < candidates.length(); i++) {
                        JSONObject content = candidates.getJSONObject(i).getJSONObject("content");
                        JSONArray parts = content.getJSONArray("parts");
                        for (int j = 0; j < parts.length(); j++) {
                            message.append(parts.getJSONObject(j).getString("text")).append("\n");
                        }
                    }
                    return message.toString().trim();
                } else {
                    return "No candidates found in the response.";
                }
            }
        } else if (responseCode == 401) {
            throw new RuntimeException("Failed : HTTP error code : 401 Unauthorized. Please check your API key and permissions.");
        } else if (responseCode == 400) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                throw new RuntimeException("Failed : HTTP error code : 400 Bad Request. Response: " + response.toString());
            }
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }
}
