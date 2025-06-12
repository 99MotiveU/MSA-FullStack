package com.my.sts.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {
	@Id
	private int deptno;
	@Column(length = 10,nullable = true)
	private String dname;
	@Column(length = 10,nullable =false,name = "locaTion")
	private String loc;
	
	// 읽기 전용
	@OneToMany(mappedBy = "dept",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Emp> emps=new ArrayList<>();
}
