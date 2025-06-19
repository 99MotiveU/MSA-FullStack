package com.sts.sts34.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sts.sts34.model.DeptRepo;
import com.sts.sts34.model.DeptVo;
import com.sts.sts34.model.entity.Dept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final DeptRepo deptRepo;
    
    public List<DeptVo> selectAll(){
        List<DeptVo> list=new ArrayList<>();
        Iterable<Dept> result = deptRepo.findAll();
        result.forEach(bean->list.add(bean.voBuild()));
        return list;
    }

    public DeptVo insertOne(DeptVo bean){
        return deptRepo.save(
                            Dept.builder()
                                .deptno(bean.getDeptno())
                                .dname(bean.getDname())
                                .loc(bean.getLoc())
                                .build()
                        ).voBuild();
    }
}
