package com.io.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("@annotation(LogMethodParam)")
    public void logMethodParameters(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        
        System.out.println("Method: " + methodName + " called with parameters:");
        for (Object arg : args) {
            System.out.println("Parameter: " + arg);
        }
    }
}
