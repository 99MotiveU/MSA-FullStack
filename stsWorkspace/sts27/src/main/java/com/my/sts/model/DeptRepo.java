package com.my.sts.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.my.sts.model.entity.Dept;

@Transactional
public interface DeptRepo extends CrudRepository<Dept,Integer> {

}
