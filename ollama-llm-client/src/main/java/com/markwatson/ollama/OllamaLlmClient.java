package com.markwatson.openai;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class OllamaLlmClient {

    public static void main(String[] args) throws Exception {
        String prompt = "Translate the following English text to French: 'Hello, how are you?'";
        String completion = getCompletion(prompt, "mistral");
        System.out.println("completion: " + completion);
    }

    public static String getCompletion(String prompt, String modelName) throws Exception {
        System.out.println("prompt: " + prompt + ", modelName: " + modelName);
 
        // New JSON message format
        JSONObject message = new JSONObject();
        message.put("prompt", prompt);
        message.put("model", modelName);
        message.put("stream", false);
        URI uri = new URI("http://localhost:11434/api/generate");
        URL url = uri.toURL();
        //System.out.println("jsonBody: " + jsonBody);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        // Send the JSON payload
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = message.toString().getBytes("utf-8");
             os.write(input, 0, input.length);
        }

        StringBuilder response;
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

        ((HttpURLConnection) connection).disconnect();

        JSONObject jsonObject = new JSONObject(response.toString());
        String s = jsonObject.getString("response");
        return s;
    }

}


