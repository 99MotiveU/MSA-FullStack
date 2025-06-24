package com.sts.emp02_1.model;

import org.springframework.data.repository.CrudRepository;

import com.sts.emp02_1.model.entity.Emp;

public interface EmpRepo extends CrudRepository<Emp,Integer>{
    
}
