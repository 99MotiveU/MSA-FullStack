package com.my.sts.dept.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeptDao {

	@Select("select * from dept")
	List<DeptVo> selectAll();
	
	@Insert("insert into dept values (#{deptno},#{dname},#{loc})")
	void insertOne(DeptVo bean);
	
	@Select("select * from dept where deptno=#{pk}")
	DeptVo selectOne(int pk);
	
	@Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
	int updateOne(DeptVo bean);

	@Delete("delete from dept where deptno=#{pk}")
	int deleteOne(int pk);
}











