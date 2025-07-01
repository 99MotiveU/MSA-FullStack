package com.sts.servicee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sts.servicee.domain.EmpRepo;
import com.sts.servicee.domain.EmpVo;
import com.sts.servicee.domain.entity.Emp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalService {
    final EmpRepo empRepo;

    public List<EmpVo> selectAll(){
        List<EmpVo> list=new ArrayList<>();
        empRepo.findAll().forEach(dept->{list.add(dept.voBuild());});
        return list;
    }

    public EmpVo add(EmpVo bean){
        if(!empRepo.findById(bean.getEname()).isPresent())
            return empRepo.save(Emp.builder()
                        .email(bean.getEmail())
                        .ename(bean.getEname())
                        .pw(bean.getPw())
                        .build()).voBuild();
        throw new RuntimeException("기존 사용자입니다.");
    }
}
