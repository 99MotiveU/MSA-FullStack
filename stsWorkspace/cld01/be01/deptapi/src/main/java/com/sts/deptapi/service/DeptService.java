package com.sts.deptapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sts.deptapi.model.DeptRepo;
import com.sts.deptapi.model.DeptVo;
import com.sts.deptapi.model.entity.Dept;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptService {
    private final DeptRepo deptRepo;

    public List<DeptVo> selectAll(){
        List<Dept> list = deptRepo.findAll();
        return list.stream().map(ele->ele.voBuild()).toList();
    }

    public DeptVo insertOne(DeptVo bean) {
        Dept dept=deptRepo.save(Dept.builder()
                                .deptno(bean.getDeptno())
                                .dname(bean.getDname())
                                .loc(bean.getLoc())
                                .build());
        return dept.voBuild();
    }

    public DeptVo selectOne(int deptno){
        Optional<Dept> opt=deptRepo.findById(deptno);
        return opt.get().voBuild();
    }

    public DeptVo updateOne(DeptVo bean){
        if(deptRepo.findById(bean.getDeptno()).isPresent())
            return deptRepo.save(Dept.builder()
                            .deptno(bean.getDeptno())
                            .dname(bean.getDname())
                            .loc(bean.getLoc())
                            .build()).voBuild();
        else 
            return null;
    }

    public DeptVo deleteOne(int deptno){
        DeptVo dept=deptRepo.findById(deptno).get().voBuild();
        deptRepo.deleteById(dept.getDeptno());
        return dept;
    }
}
