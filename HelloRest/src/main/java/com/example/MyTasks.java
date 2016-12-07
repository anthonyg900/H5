package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyTasks {
    @Scheduled(fixedRate = 5000)
    public void periodicTasks1(){
        System.out.println("The time is now: " + new Date());
    }
}
