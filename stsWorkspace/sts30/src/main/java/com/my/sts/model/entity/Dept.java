package com.my.sts.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("dept")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {
	@Id
	private int deptno;
	private String dname,loc;
}
