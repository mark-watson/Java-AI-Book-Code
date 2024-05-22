package com.markwatson.langchain4j_ollama;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

public class OllamaLlmLangChain4j {

    public static void main(String[] args) throws Exception {
        String prompt = "Translate the following English text to French: 'Hello, how are you?'";
        String completion = getCompletion(prompt, "mistral");
        System.out.println("completion: " + completion);
    }

    public static String getCompletion(String prompt, String modelName) throws Exception {
        System.out.println("\n\n**********\n\nprompt: " + prompt + ", modelName: " + modelName);
        String api_key = System.getenv("OPENAI_API_KEY");

        ChatLanguageModel model = OpenAiChatModel.withApiKey(api_key);
        String answer = model.generate(prompt);

        System.out.println(answer); // Hello! How can I assist you today?
        return answer;
    }

    /***
     * Utilities for using the Ollama LLM APIs
     */

    // read the contents of a file path into a Java string
    public static String readFileToString(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return new String(Files.readAllBytes(path));
    }

    public static String replaceSubstring(String originalString, String substringToReplace, String replacementString) {
        return originalString.replace(substringToReplace, replacementString);
    }
    public static String promptVar(String prompt0, String varName, String varValue) {
        String prompt = replaceSubstring(prompt0, varName, varValue);
        return replaceSubstring(prompt, varName, varValue);
    }   
}




