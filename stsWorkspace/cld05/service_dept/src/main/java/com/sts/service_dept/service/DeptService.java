package com.sts.service_dept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.sts.service_dept.domain.DeptRepo;
import com.sts.service_dept.domain.DeptVo;
import com.sts.service_dept.domain.entity.Dept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptService {
    final DeptRepo deptRepo;

    public List<DeptVo> selectAll(){
        List<DeptVo> list=new ArrayList<>();
        deptRepo.findAll().forEach(dept->list.add(dept.voBuild()));
        return list;
    }

    public DeptVo insertOne(DeptVo bean){
        Optional<Dept> opt = deptRepo.findByDname(bean.getDname());
        DeptVo result=DeptVo.builder().build();
        opt.ifPresentOrElse(dept->{
            throw new RuntimeException(dept.getDname()+"이 존재합니다");
        },()->{
            Dept result2=deptRepo.save(Dept.builder()
                            .deptno(0)
                            .dname(bean.getDname())
                            .loc(bean.getLoc())
                            .build());
            result.setDeptno(result2.getDeptno());
            result.setDname(result2.getDname());
            result.setLoc(result2.getLoc());
        });
        return result;
    }
}
