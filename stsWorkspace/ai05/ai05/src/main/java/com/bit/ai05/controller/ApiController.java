package com.bit.ai05.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.ai05.service.VectorService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    final VectorService vectorService;
    final OllamaChatModel chatModel;
    final VectorStore elasticsearchVectorStore;
    
    @GetMapping("/init")
    public List<Document> getMethodName() {
        System.out.println("call init...");
        return vectorService.init();

    }
    
    // @GetMapping(value="/",produces = "text/plain;charset=UTF-8")
    @GetMapping(value="/")
    public Flux<String> getMethodName(String msg) {
        ChatClient chatClient = ChatClient.create(chatModel);
        SystemMessage systemMessage = new SystemMessage("");
        UserMessage userMessage = new UserMessage(msg);
        AssistantMessage assistantMessage = new AssistantMessage("");

        Prompt prompt = new Prompt(List.of(systemMessage, userMessage, assistantMessage));

        StringBuilder responseBuffer = new StringBuilder();
        QuestionAnswerAdvisor ragAdvisor = QuestionAnswerAdvisor.builder(elasticsearchVectorStore)
            .searchRequest(SearchRequest.builder().similarityThreshold(0.25d).topK(6).build())
            .build();
        return chatClient.prompt(prompt)
            // .tools(null)
            .advisors(ragAdvisor)
            .stream()
            .content()
            .map(token -> {
                responseBuffer.append(token);
                return new String(token.getBytes(StandardCharsets.UTF_8),Charset.forName("utf-8"));
            })
            .doOnComplete(() -> {
                System.out.println("============================================");
                System.out.println(responseBuffer);
                System.out.println("============================================");
            });
    }
    
    
}
