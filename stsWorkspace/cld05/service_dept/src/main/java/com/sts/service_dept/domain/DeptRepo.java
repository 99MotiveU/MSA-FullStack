package com.sts.service_dept.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sts.service_dept.domain.entity.Dept;


public interface DeptRepo extends CrudRepository<Dept,Integer> {
    Optional<Dept> findByDname(String dname);
}
