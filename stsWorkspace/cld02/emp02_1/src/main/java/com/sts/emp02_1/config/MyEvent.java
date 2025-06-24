package com.sts.emp02_1.config;

import java.time.Clock;

import org.springframework.context.ApplicationEvent;

import com.sts.emp02_1.model.EmpVo;

import lombok.AllArgsConstructor;
import lombok.Builder;

public class MyEvent extends ApplicationEvent {
    public Type type=Type.ALL;
    public EmpVo params;
    public static Type ALL;
    public static Type ADD;
    public static Type EDIT;
    public static Type DEL;

    private enum Type{
        ALL,ADD,EDIT,DEL
    }
    @AllArgsConstructor
    @Builder
    public static class MyEvent2 {
        public Type type;
        public EmpVo params;
    }

    public MyEvent(MyEvent2 source) {
        super(source);
        this.type=source.type;
        this.params=source.params;
    }
    
}
