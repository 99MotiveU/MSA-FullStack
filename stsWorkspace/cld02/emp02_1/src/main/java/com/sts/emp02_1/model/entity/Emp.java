package com.sts.emp02_1.model.entity;

import com.sts.emp02_1.model.EmpVo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empno;
    private String ename;
    private String job;
    private int sal;

    public EmpVo voBuild(){
        return EmpVo.builder()
                .empno(empno)
                .ename(ename)
                .job(job)
                .sal(sal)
                .build();
    }
}
