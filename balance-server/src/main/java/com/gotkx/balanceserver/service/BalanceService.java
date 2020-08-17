package com.gotkx.balanceserver.service;

import com.gotkx.balanceserver.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user-server", fallback = Fallback.class)
public interface BalanceService {

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    public List<User> findAllUsers(@RequestParam String name);

}
