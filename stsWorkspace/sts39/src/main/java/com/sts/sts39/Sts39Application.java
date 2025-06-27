package com.sts.sts39;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.sts.config.JwtFilter;

@SpringBootApplication
public class Sts39Application {

    public static void main(String[] args) {
        SpringApplication.run(Sts39Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterBean() {
        FilterRegistrationBean bean=new FilterRegistrationBean<>();
        bean.setFilter(new JwtFilter());
        return bean;
    }
}
