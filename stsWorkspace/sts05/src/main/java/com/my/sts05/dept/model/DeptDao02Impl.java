package com.my.sts05.dept.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class DeptDao02Impl implements DeptDao {
	@Autowired
//	SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<DeptVo> selectAll() {
//		return sqlMapClientTemplate.queryForList("selectAll");
		return null;
	}

	@Override
	public DeptVo selectOne(int pk) {
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) {
//		sqlMapClientTemplate.insert("insertOne",bean);
	}

	@Override
	public int updateOne(DeptVo bean) {
		return 0;
	}

	@Override
	public int deleteOne(int pk) {
		return 0;
	}

	@Override
	public int totSize() {
		return 0;
	}

}
