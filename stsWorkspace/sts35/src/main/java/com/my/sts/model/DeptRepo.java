package com.my.sts.model;

import org.springframework.data.repository.CrudRepository;

import com.my.sts.model.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept, Integer>{

}
