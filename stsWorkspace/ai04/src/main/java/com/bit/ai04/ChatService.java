package com.bit.ai04;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ChatService {
    final ChatMemoryRepository chatMemoryRepository;
    final ChatModel chatModel;

    public Flux<String> func01(String username,String msg){

        ChatMemory chatMemory = MessageWindowChatMemory.builder()
            .maxMessages(10)
            .chatMemoryRepository(chatMemoryRepository)
            .build();
        chatMemory.add(username, new UserMessage(msg));
        StringBuilder buffer = new StringBuilder();
        Prompt pmplist=new Prompt(chatMemory.get(username));
        
        return ChatClient.create(chatModel)
        // .prompt(msg)
        .prompt(pmplist)
        // .tools()
        .stream()
        .content()
        .map(result->{
                buffer.append(result);
                return result;
        })
        .doOnComplete(()->{
            chatMemory.add(username, new AssistantMessage(buffer.toString()));
            chatMemoryRepository.saveAll(username, chatMemory.get(username));
        })
        ;
    }
}
