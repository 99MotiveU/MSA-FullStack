package com.sts.emp02_1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.sts.emp02_1.model.EmpRepo;
import com.sts.emp02_1.model.EmpVo;
import com.sts.emp02_1.model.entity.Emp;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepo empRepo;
    
    public ListIterator<EmpVo> selectAll(){
        List<EmpVo> list=new ArrayList<>();
        empRepo.findAll().forEach(ele->{list.add(ele.voBuild());});
        return list.listIterator();
    }

    public EmpVo insertOne(EmpVo bean){
        Emp emp=Emp.builder()
                    .empno(bean.getEmpno())
                    .ename(bean.getEname())
                    .job(bean.getJob())
                    .sal(bean.getSal())
                    .build();
        return empRepo.save(emp).voBuild();
    }
}
