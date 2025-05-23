package com.my.sts.dept.model;

import java.util.List;

public interface DeptDao {

	List<DeptVo> selectAll();
	DeptVo selectOne(int pk);
	int insertOne(DeptVo bean);
	int updateOne(DeptVo bean);
	int deleteOne(int pk);
}
