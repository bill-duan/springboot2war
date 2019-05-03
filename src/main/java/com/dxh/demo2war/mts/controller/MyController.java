package com.dxh.demo2war.mts.controller;

import com.alibaba.fastjson.JSON;
import com.dxh.demo2war.mts.entity.User;
import com.dxh.demo2war.mts.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oop")
public class MyController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试api接口")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/api/my/say", method = RequestMethod.GET)
    public String say(@RequestParam("userId") Long userId){
        System.out.println(10/userId);
        return "success";
    }

    @ApiOperation(value = "查询用户信息")
    @RequestMapping(value = "/api/user/get", method = RequestMethod.GET)
    public User getUser(@RequestParam("userId") Long userId){
        System.out.println("userId: "+userId);
        User user = userService.findById(userId);
        System.out.println("user: "+user);
        return user;
    }

    @ApiOperation(value = "保存用户信息")
    @RequestMapping(value = "/api/user/save", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user){
        System.out.println("user: "+ JSON.toJSONString(user));
        userService.save(user);
        return "success";
    }
}
