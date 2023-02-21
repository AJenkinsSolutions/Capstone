package com.jenkins.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This will handle all public request. ie re
 */
@Controller
@RequestMapping("public")
public class PublicController {

    @RequestMapping(value = "/signup", method = {RequestMethod.GET})
    public String showSignupView(Model model) {

//        TODO -
        return "signup";
    }
}
