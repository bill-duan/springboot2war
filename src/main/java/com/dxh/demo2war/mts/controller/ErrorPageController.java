package com.dxh.demo2war.mts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

    @RequestMapping(value = "/404")
    public String error404(){
        System.out.println("404.html");
        return "error/404";
    }

    @RequestMapping(value = "/405")
    public String error405(){
        return "error/404";
    }

    @RequestMapping(value = "/500")
    public String error500(){
        return "error/500";
    }


}
