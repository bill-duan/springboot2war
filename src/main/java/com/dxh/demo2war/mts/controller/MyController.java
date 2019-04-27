package com.dxh.demo2war.mts.controller;

import com.alibaba.fastjson.JSON;
import com.dxh.demo2war.mts.entity.User;
import com.dxh.demo2war.mts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oop")
public class MyController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/my/say", method = RequestMethod.GET)
    public String say(@RequestParam("userId") Long userId){
        System.out.println(userId);
        return "success";
    }

    @RequestMapping(value = "/api/user/get", method = RequestMethod.GET)
    public User getUser(@RequestParam("userId") Long userId){
        System.out.println("userId: "+userId);
        User user = userService.findById(userId);
        System.out.println("user: "+user);
        return user;
    }

    @RequestMapping(value = "/api/user/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user){
        System.out.println("user: "+ JSON.toJSONString(user));
        userService.save(user);
        return "success";
    }
}
