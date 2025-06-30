package com.sts.servicee.domain.entity;

import com.sts.servicee.domain.EmpVo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(length = 10)
    String ename;
    @Column(length = 50)
    String email;
    @Column(length = 64)
    String pw;
    public EmpVo voBuild(){
        return EmpVo.builder().email(email).ename(ename).pw(pw).build();
    }
}
