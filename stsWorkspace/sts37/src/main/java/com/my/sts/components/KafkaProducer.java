package com.my.sts.components;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.sts.model.DeptVo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
	final KafkaTemplate<String, Object> template;
	final ObjectMapper objectMapper;

	public void pub(DeptVo bean) throws JsonProcessingException {
		template.send("pic02", objectMapper.writeValueAsString(bean));
	}

}
