package com.bit.ai05;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;

// @Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient openAiChatClient(OllamaChatModel chatModel) {
        return ChatClient.create(chatModel);
    }
    
}
