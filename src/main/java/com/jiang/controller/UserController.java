package com.jiang.controller;

import com.jiang.common.Result;
import com.jiang.entity.User;
import com.jiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public Result userAdd() {
        List<User> add =userService.list();
        return Result.succ(add);
    }

}
