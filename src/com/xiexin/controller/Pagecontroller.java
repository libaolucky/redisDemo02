package com.xiexin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pagecontroller {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/")
    public String index1(){
        return "index";
    }
    @RequestMapping("/addBusiness")
    public String addBusiness(){
        return "addBusiness";
    }

    @RequestMapping("/vuedemo00")
    public String vuedemo00(){
        return "vuedemo00";
    }
       @RequestMapping("/vuedemo01")
    public String vuedemo01(){
        return "vuedemo01";
    }

    @RequestMapping("/vuedemo002")
    public String vuedemo002(){
        return "vuedemo002";
    }

    @RequestMapping("/vuedemo003")
    public String vuedemo003(){
        return "vuedemo003";
    }

    @RequestMapping("/vuedemo004")
    public String vuedemo004(){
        return "vuedemo004";
    }

    @RequestMapping("/VueZuoYe")
    public String VueZuoYe(){
        return "VueZuoYe";
    }

    @RequestMapping("/BusinessList")
    public String BusinessList(){
        return "BusinessList";
    }

    @RequestMapping("/jiantouhanshu")
    public String jiantouhanshu(){
        return "jiantouhanshu";
    }
    @RequestMapping("/biList")
    public String biList(){
        return "biList";
    }

}
