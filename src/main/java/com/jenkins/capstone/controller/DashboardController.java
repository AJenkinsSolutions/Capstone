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



    /**
     * Session management
     * When as valid user reaches the dashboard page we will load the users details in the session
     * Now we can use that 'currentLoggedUser' throughout the current session
     * HttpSession
     */
    @ExceptionHandler
    @RequestMapping("/dashboard")
    public String showDashboardView(Model model, Authentication authentication, HttpSession session){


//        step-1: use the authenticationObj to get the principle 'email', get user from DB
//        Optional: Add user deatils to model
//        Step-2: add currentLogged in user to the seesio with 'setAttribute'
        Developer developer = developerRepository.findByEmail(authentication.getName());
        model.addAttribute("username", developer.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        session.setAttribute("currentLoggedUser", developer);
        return "dashboard";
    }







}
