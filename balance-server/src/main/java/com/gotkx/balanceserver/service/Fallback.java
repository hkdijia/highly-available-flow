package com.gotkx.balanceserver.service;

import com.gotkx.balanceserver.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Fallback implements BalanceService{

    @Override
    public List<User> findAllUsers(String name) {
        User user = new User(12L, "黄凯", 24);
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }
}
