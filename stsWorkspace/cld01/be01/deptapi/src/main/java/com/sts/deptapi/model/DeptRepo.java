package com.sts.deptapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.deptapi.model.entity.Dept;

public interface DeptRepo extends JpaRepository<Dept,Integer>{
    
}
