package com.sudreeshya.aop.demo.controller;

import com.sudreeshya.aop.demo.service.AOPTesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private AOPTesterService service;

    @GetMapping("before")
    public String callBeforeAdvice() {
        service.callMe2();
        service.callMe3();
        return "called";
    }
}
