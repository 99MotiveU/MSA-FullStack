package com.my.sts.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.my.sts.model.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept, Integer>{

	List<Dept> findByDname(String dname);

//	Dept findById(int id);
}
