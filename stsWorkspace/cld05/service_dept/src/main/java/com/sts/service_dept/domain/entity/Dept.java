package com.sts.service_dept.domain.entity;

import com.sts.service_dept.domain.DeptVo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int deptno;
    String dname;
    String loc;
    public DeptVo voBuild(){
        return DeptVo.builder()
                    .deptno(deptno).dname(dname).loc(loc)
                    .build();
    }
}
