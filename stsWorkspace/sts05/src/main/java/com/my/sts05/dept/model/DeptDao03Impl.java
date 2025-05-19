package com.my.sts05.dept.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao03Impl implements DeptDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<DeptVo> selectAll() {
		return sqlSessionTemplate.selectList("dept.selectAll");
	}

	@Override
	public DeptVo selectOne(int pk) {
		return sqlSessionTemplate.selectOne("dept.selectOne",pk);
	}

	@Override
	public void insertOne(DeptVo bean) {
		sqlSessionTemplate.insert("dept.insertOne",bean);
	}

	@Override
	public int updateOne(DeptVo bean) {
		return sqlSessionTemplate.update("dept.updateOne",bean);
	}

	@Override
	public int deleteOne(int pk) {
		return sqlSessionTemplate.delete("dept.deleteOne",pk);
	}

	@Override
	public int totSize() {
		return 0;
	}

}
