package com.dxh.demo2war.mts.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageController {

    @RequestMapping(value = "/error/{code}")
    public String error(@PathVariable int code, Model model) {
        String pager = "";
        switch (code) {
            case 403:
                model.addAttribute("code", 403);
                pager = "static/errorpage/403.html";
                break;
            case 404:
                model.addAttribute("code", 404);
                pager = "static/errorpage/404.html";
                break;
            case 500:
                model.addAttribute("code", 500);
                pager = "static/errorpage/500.html";
                break;
        }
        return pager;
    }

}
