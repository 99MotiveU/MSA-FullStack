package com.my.sts;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receiver {

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        log.info("Received <" + message + ">"); 
        // Received 대신 service or repository 주입받아서 이 내용을가지고 DataBase에 작성을 하게된다.
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
