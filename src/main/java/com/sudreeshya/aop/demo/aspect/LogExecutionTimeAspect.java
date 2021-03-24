package com.sudreeshya.aop.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Aspect
@Slf4j
@Component
public class LogExecutionTimeAspect {


    @Around("@annotation(com.sudreeshya.aop.demo.annotation.LogExecutionTime)")
    public void aroundExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Measure method execution time
        log.debug("Executing from class: {}", proceedingJoinPoint.getSignature().getDeclaringTypeName());
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        log.debug("Executing method: {}", method.getName());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(proceedingJoinPoint.getSignature().getDeclaringTypeName() + "->" + method.getName());
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        // Log method execution time
        log.info(stopWatch.shortSummary());
    }
}
