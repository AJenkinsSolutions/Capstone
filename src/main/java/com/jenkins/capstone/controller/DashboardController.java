package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.repository.DeveloperRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This will handel user request with dashboard
 */
@Controller
public class DashboardController {

    @Autowired
    DeveloperRepository developerRepository;

    @ExceptionHandler
    @RequestMapping("/dashboard")
    public String showDashboardView(Model model, Authentication authentication, HttpSession session){
        /**
         * Session management
         * HttpSession
         */
        System.out.println(authentication.toString());
        //Lets fecth the logged-in user data from the db
        Developer developer = developerRepository.readByName(authentication.getName());
        //Spring is pullin the name from the developer to authenticate
        model.addAttribute("username", developer.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
//        throw new RuntimeException("It's been a bad day Error");
        return "dashboard";
    }

}
