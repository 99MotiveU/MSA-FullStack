package com.my.sts.model.entity;

import com.my.sts.model.DeptVo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)// oracle:sequence
//	@GeneratedValue(strategy = GenerationType.TABLE)// sequence에 해당하는 테이블을 만들어 관리
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptno;
	@Column(length = 10,nullable = false)
	private String dname;
	@Column(length = 10,nullable = true)
	private String loc;
//	@Transient
//	@Column(columnDefinition = "TEXT")
//	private String memo;
	
	public DeptVo voBuild() {
		return DeptVo.builder()
				.deptno(deptno)
				.dname(dname)
				.loc(loc)
				.build();
	}
}











