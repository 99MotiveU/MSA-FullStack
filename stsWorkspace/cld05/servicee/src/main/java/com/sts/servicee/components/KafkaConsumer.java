package com.sts.servicee.components;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sts.servicee.domain.EmpRepo;
import com.sts.servicee.domain.EmpVo;
import com.sts.servicee.service.LocalService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    final LocalService service;
    final ObjectMapper objectMapper;

    @KafkaListener(topics = "emppic",groupId = "myGroup")
    public void event(ConsumerRecord record) throws JsonMappingException, JsonProcessingException{
        // Object key = record.key();
        Object val = record.value();
        System.out.println("val:{}".format(record.toString()));
        // EmpVo bean=objectMapper.readValue(msg, EmpVo.class);
        // service.add(bean);
    }
}
