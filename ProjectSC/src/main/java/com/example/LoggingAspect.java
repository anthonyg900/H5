package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect

//Used for logging  each Method that
//is executed

public class LoggingAspect {
    @Pointcut("execution(public * com.example..*(..))")
    public void publicMethod(){}

    @Before("publicMethod()")
    public void addLog(final JoinPoint joinPoint){
        System.out.println("*** Executing: " + joinPoint.getSignature());
        Object[] arguments = joinPoint.getArgs();
        for(Object argument : arguments){
            System.out.println("*** "+argument.getClass().getSimpleName()+ " = " + argument);
        }
    }
}
