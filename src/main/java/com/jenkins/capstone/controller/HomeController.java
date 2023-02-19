package com.jenkins.capstone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * Displays the home view
     * @return
     */
    @RequestMapping(value = {"", "/", "home"})
    public String displayHomeView(){
        return "home.html";
    }
}
