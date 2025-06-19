package com.sts.sts34.model;

import org.springframework.data.repository.CrudRepository;

import com.sts.sts34.model.entity.Dept;

public interface DeptRepo extends CrudRepository<Dept,Integer> {
    Dept findByDname(String dname);
}
