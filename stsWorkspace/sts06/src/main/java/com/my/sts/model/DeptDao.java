package com.my.sts.model;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

//@Transactional
public interface DeptDao {

	List<DeptVo> selectAll();
	DeptVo select(int pk);
	void insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int pk);
}
