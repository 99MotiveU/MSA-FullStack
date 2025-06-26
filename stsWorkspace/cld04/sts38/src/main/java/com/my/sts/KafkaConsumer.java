package com.my.sts;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "pic02",groupId = "myGroup")
	public void event(String msg) throws JsonMappingException, JsonProcessingException {
		
		System.out.println(msg);
	}
}




