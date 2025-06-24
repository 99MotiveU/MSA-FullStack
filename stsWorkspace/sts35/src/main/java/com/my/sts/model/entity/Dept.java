package com.my.sts.model.entity;

import com.my.sts.model.DeptVo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {
	@Id
	private int deptno;
	private String dname,loc;
	
	public DeptVo voBuild() {
		return DeptVo.builder().deptno(deptno).dname(dname).loc(loc).build();
	}
}









