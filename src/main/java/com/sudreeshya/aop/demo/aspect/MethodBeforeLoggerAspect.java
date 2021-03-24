package com.sudreeshya.aop.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Component
@Aspect
@Slf4j
public class MethodBeforeLoggerAspect {

    @Before("execution(* callMe(..))")
    public void entering() {
        log.debug("Entering method");
    }
}
