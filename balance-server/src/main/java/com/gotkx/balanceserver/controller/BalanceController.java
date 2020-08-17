package com.gotkx.balanceserver.controller;

import com.gotkx.balanceserver.model.User;
import com.gotkx.balanceserver.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

//    @Value("${defaultName}")
//    private String defaultName;

    @RequestMapping("/findAllUsers")
    public List<User> findAllUsers(@RequestParam String name){
        System.out.println("走的是负载均衡");
        if(!StringUtils.isEmpty(name)){
            System.out.println(name);
        }

        return balanceService.findAllUsers(name);
    }

}
