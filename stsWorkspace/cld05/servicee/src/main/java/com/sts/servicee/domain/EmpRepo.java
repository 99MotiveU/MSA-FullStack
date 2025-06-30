package com.sts.servicee.domain;

import org.springframework.data.repository.CrudRepository;

import com.sts.servicee.domain.entity.Emp;

public interface EmpRepo extends CrudRepository<Emp,String>{
    
}
