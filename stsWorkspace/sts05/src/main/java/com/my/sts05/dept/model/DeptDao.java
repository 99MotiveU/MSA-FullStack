package com.my.sts05.dept.model;

import java.util.List;

public interface DeptDao {

	List<DeptVo> selectAll();
	DeptVo selectOne(int pk);
	void insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int pk);
	int totSize();
}
