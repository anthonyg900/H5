package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//Created by Anthony on 12/7/2016.

@Component
@Aspect
public class FaithfulAspect {
    @Pointcut("execution(public * com.example..*(..))")
    public void allMethods(){}

    @Before("allMethods() && @annotation(AtChurch)")
    public void pray(final JoinPoint joinPoint){
        doPray();
    }

    private void doPray() {
        System.out.println("############PRAY BEFORE EVERY MEAL!#################");
    }

    @After("allMethods()")
    public void praiseAndGiveGloryToGod(final JoinPoint joinPoint){
        doPraiseAndGiveGlory();
    }

    private void doPraiseAndGiveGlory() {
        System.out.println("#############PRAY AND GIVE GLORY!!###################");
    }
}
