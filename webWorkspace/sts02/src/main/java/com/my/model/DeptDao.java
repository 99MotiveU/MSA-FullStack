package com.my.model;

import java.util.List;

public interface DeptDao {

	List<DeptDto> selectAll();

	DeptDto selectOne(int deptno);

	void insertOne(DeptDto bean);

	int updateOne(DeptDto bean);

	int deleteOne(int deptno);

}