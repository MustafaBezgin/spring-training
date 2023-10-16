package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home") // it is named "end point" and it will concatenate with url
    public String getHomePage() {
        return "home.html";
    }

    @RequestMapping("/abcd")
    public String getHomePage2() {
        return "home.html";
    }

    @RequestMapping // nothing or only "/" to direct us default page
    public String getHomePage3() {
        return "home.html";
    }

    @RequestMapping({"/apple", "/orange"})
    public String getHomePage4() {
        return "home.html";
    }
}
