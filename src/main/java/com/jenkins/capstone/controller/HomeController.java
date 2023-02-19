package com.jenkins.capstone.controller;


import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String displayHomeView(){
        return "Hello world";
    }
}
