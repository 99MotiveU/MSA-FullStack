package com.sts.userapi.model.entity;

import com.sts.userapi.model.UserVo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "api_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    @Column(length = 25,unique = true,nullable = false)
    private String name;
    @Column(length = 25)
    private String email;
    @Column(length = 128)
    private String pw;

    public UserVo voBuild(){
        return UserVo.builder()
                    .num(num)
                    .name(name)
                    .email(email)
                    .build();
    }
}
