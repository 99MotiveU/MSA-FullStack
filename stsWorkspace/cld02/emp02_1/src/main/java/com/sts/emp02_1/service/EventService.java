package com.sts.emp02_1.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.sts.emp02_1.config.MyEvent;

@Service
public class EventService {
    
    @EventListener
    public void func(MyEvent e){
        if(e.type==MyEvent.ALL){
            System.out.println("목록을 보여줍니다");
        }
        if(e.type==MyEvent.ADD){
            System.out.println(e.params+"로 입력");
        }
        if(e.type==MyEvent.EDIT){
            System.out.println(e.params+"로 수정");

        }
        if(e.type==MyEvent.DEL){
            System.out.println(e.params.getEmpno()+"삭제");
        }
    }
}
