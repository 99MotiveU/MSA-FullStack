package com.bit.ai02;

import java.time.LocalDateTime;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {
    final ChatModel chatModel;

    public void func01(){
        String response = ChatClient.create(chatModel)
        .prompt("한국여성기업인협회는 무엇을 하는 곳인지 한글로 설명해줘?")
        // .tools()
        .call()
        .content();

        System.out.println(response);
    }
}
