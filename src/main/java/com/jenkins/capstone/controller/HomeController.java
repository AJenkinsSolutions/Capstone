package com.jenkins.capstone.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller will Display the Home page to user
 */
@Controller
public class HomeController {

    /**
     * Displays the home view
     * @return
     */
    @RequestMapping(value = {"", "/", "inbox"})
    public String displayHomeView(){
        return "inbox";
    }
}
