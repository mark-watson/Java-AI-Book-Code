package com.markwatson.openai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenAICompletionsExample {

    public static void main(String[] args) throws Exception {
        String prompt = "Translate the following English text to French: 'Hello, how are you?'";
        String completion = getCompletion(prompt);
        System.out.println("completion: " + completion);
    }

    public static String getCompletion(String prompt) throws Exception {
        String apiKey = System.getenv("OPENAI_API_KEY");
        String model = "gpt-3.5-turbo"; // Replace with the desired model

        // New JSON message format
        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", prompt);

        JSONArray messages = new JSONArray();
        messages.put(message);

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("model", model);
        jsonBody.put("messages", messages);
        jsonBody.put("max_tokens", 60);


        // Set up the URL and open a connection
        HttpURLConnection connection;
        StringBuilder response;
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            connection = (HttpURLConnection) url.openConnection();

            // Set up the request properties
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setDoOutput(true);

            // Send the JSON payload
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }


        // Read the response from the server
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        connection.disconnect();
        JSONObject jsonObject = new JSONObject(response.toString());
        JSONArray choices = jsonObject.getJSONArray("choices");
        JSONObject messageObject = choices.getJSONObject(0).getJSONObject("message");
        String content = messageObject.getString("content");
        System.out.println("content: " + content);
        return content;
    }

}


