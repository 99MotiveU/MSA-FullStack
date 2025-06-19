package com.sts.sts34.model.entity;

import com.sts.sts34.model.DeptVo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private int deptno;
    @Column(length = 10)
    private String dname;
    @Column(columnDefinition = "text")
    private String loc;

    public DeptVo voBuild(){
        return DeptVo.builder()
                    .deptno(deptno)
                    .dname(dname)
                    .loc(loc)
                    .build();
    }
}
