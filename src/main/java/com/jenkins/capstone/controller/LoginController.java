package com.jenkins.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    /**
     *  We have 3 optional params 'error', 'logout', signup & Model
     *     we will use these params to customize our page
     */
    @GetMapping(value = "/login")
    public String showLoginView(@RequestParam(required = false, value = "error")String error,
                                @RequestParam(required = false, value = "logout")String logout,
                                @RequestParam(required = false, value = "signup")String signup, Model model){
        String alert = null;
        //Depending on the contents of our optional Request Params
        //Alert - danger || success || info
        if(error != null){
            alert = "Username Or passward wrong";
        } else if (logout != null){
            alert = "Youve been logged out";
        } else if (signup != null){
            alert = "Registration Complete!!!, Login with new credentials";
        }
        //Add it to the model
        model.addAttribute("alert", alert);
        return "/login";
    }




}
