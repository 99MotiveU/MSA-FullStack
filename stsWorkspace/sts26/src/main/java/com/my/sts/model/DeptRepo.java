package com.my.sts.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.my.sts.model.entity.Dept;

public interface DeptRepo 
	extends CrudRepository<Dept, Integer> {
//	extends JpaRepository<Dept, Integer> {
//	List<Dept> findAll();
}
