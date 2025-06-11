package com.my.sts.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeptVo {
	private int deptno;
	private String dname;
	private String loc;
}
