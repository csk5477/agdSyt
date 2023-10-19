package com.agdsyt.controller;

import com.agdsyt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 控制器，
 */
@RestController
@RequestMapping("/user")
public class UserController {
    //注入服务类
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public Object findAll(){
        return userService.findAll();
    }
}
