package com.markwatson.gemini;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
//import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeminiCompletions {

    public static String model = "gemini-3-flash-preview";

    public static void main(String[] args) throws Exception {
        String prompt = "How much is 11 + 22?";
        String completion = getCompletion(prompt);
        System.out.println("completion: " + completion);
    }

    public static String getCompletion(String prompt) throws Exception {
        String jsonBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + prompt + "\"}]}]}";
        return executeRequest(jsonBody);
    }

    public static String getCompletionWithSearch(String prompt) throws Exception {
        String jsonBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + prompt
                + "\"}]}],\"tools\":[{\"google_search\":{}}]}";
        return executeRequest(jsonBody);
    }

    private static String executeRequest(String jsonBody) throws Exception {
        String apiKey = System.getenv("GOOGLE_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IOException("GOOGLE_API_KEY environment variable not set.");
        }
        URI uri = new URI(
                "https://generativelanguage.googleapis.com/v1beta/models/" + model + ":generateContent?key=" + apiKey);
        URL url = uri.toURL();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        connection.disconnect();
        JSONObject jsonObject = new JSONObject(response.toString());
        return jsonObject.getJSONArray("candidates").getJSONObject(0).getJSONObject("content").getJSONArray("parts")
                .getJSONObject(0).getString("text");
    }

    /***
     * Utilities for using the Gemini API
     */

    // read the contents of a file path into a Java string
    public static String readFileToString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return new String(Files.readAllBytes(path)).replace("\"", "\\\"");
    }

    public static String replaceSubstring(String originalString, String substringToReplace, String replacementString) {
        return originalString.replace(substringToReplace, replacementString);
    }

    public static String promptVar(String prompt0, String varName, String varValue) {
        String prompt = replaceSubstring(prompt0, varName, varValue);
        return replaceSubstring(prompt, varName, varValue);
    }
}
