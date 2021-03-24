package com.sudreeshya.aop.demo.service;

import com.sudreeshya.aop.demo.annotation.MethodLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@Slf4j
@Service
public class AOPTesterService {

//    @LogExecutionTime
    public void callMe(int i, int j) {
        // our biz logic
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {
        }
        log.info("Executing biz");
    }

    public void callMe() {
        // our biz logic
        log.info("Executing biz");
    }

    @MethodLogger
    public void callMe2() {
        // our biz logic
        log.info("Executing biz 1");
    }

    @MethodLogger
    public void callMe3() {
        // our biz logic
        log.info("Executing biz 2");
    }
}
