package com.my.sts;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.my.sts.KafkaConfig;
//import com.my.sts.model.DeptVo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
	private final ObjectMapper objectMapper;

	@KafkaListener(topics = "pic02",groupId = "myGroup")
	public void event(String msg) throws JsonMappingException, JsonProcessingException {
		DeptVo bean=objectMapper.readValue(msg, DeptVo.class);
		System.out.println(bean);
	}
}




