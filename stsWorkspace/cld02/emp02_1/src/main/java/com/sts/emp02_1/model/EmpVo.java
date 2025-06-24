package com.sts.emp02_1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpVo {
    private int empno;
    private String ename;
    private String job;
    private int sal;
}
