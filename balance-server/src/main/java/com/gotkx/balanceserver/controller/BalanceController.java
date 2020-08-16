package com.gotkx.balanceserver.controller;

import com.gotkx.balanceserver.model.User;
import com.gotkx.balanceserver.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @RequestMapping("/findAllUsers")
    public List<User> findAllUsers(){
        System.out.println("走的是负载均衡");
        return balanceService.findAllUsers();
    }

}
