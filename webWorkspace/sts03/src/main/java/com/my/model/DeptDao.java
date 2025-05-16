package com.my.model;

import java.util.List;

public interface DeptDao {

	List<DeptDto> selectAll();

	void insertOne(DeptDto deptDto);

	DeptDto selectOne(int deptno);

	int updateOne(DeptDto command);

	int deleteOne(int deptno);

}