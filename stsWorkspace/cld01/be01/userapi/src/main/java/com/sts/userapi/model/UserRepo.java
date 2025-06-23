package com.sts.userapi.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sts.userapi.model.entity.User;

public interface UserRepo extends CrudRepository<User,Integer>{

    Optional<User> findByNameAndPw(String name, String pw);

    User findByName(String name);
    
}
