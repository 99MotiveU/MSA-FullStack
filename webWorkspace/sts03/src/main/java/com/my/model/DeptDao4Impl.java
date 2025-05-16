package com.my.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DeptDao4Impl extends SqlMapClientDaoSupport implements DeptDao {
	@Override
	public List<DeptDto> selectAll(){
		return getSqlMapClientTemplate().queryForList("selectAll");
	}

	@Override
	public void insertOne(DeptDto bean) {
		getSqlMapClientTemplate().insert("insertOne",bean);
	}

	@Override
	public DeptDto selectOne(int deptno) {
		return (DeptDto) getSqlMapClientTemplate().queryForObject("selectOne",deptno);
	}

	@Override
	public int updateOne(DeptDto bean) {
		return getSqlMapClientTemplate().update("updateOne",bean);
	}

	@Override
	public int deleteOne(int deptno) {
		return getSqlMapClientTemplate().delete("deleteOne",deptno);
	}
	
}









