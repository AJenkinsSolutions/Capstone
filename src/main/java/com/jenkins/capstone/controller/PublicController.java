package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.service.DeveloperService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This will handle all public request. ie re
 */
@Controller
@RequestMapping("public")
public class PublicController {

    @Autowired
    private DeveloperService developerService;

    /**
     * This is our Entry point into the 'sign up View'
     * Let's 'HAND OFF' Developer Entity to the view layer
     * @param model - How the view layer holds the values we hand to it
     * @return
     */
    @ExceptionHandler
    @RequestMapping(value = "/signup", method = {RequestMethod.GET})
    public String showSignupView(Model model) {
        model.addAttribute("developer", new Developer());
        return "signup.html";
    }


    /**
     * We need to pick our developer object form
     * On Post
     * Check form Valid
     * Redirect
     * @param developer
     * @param errors
     * @return View
     */
    @ExceptionHandler
    @RequestMapping(value = "/addAccount", method = {RequestMethod.POST})
    public String addAccount(@Valid @ModelAttribute("developer") Developer developer, Errors errors){
        if(errors.hasErrors()){
            return "signup";
        }
        boolean saveComplete = developerService.AddDeveloper(developer);
        if (saveComplete){
            return "redirect:/login?=true";
        }
        return "signup";





    }



}
