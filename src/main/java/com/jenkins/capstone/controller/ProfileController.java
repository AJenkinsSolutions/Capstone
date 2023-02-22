package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @RequestMapping(value = "/showUserProfileView", method = RequestMethod.GET)
    public ModelAndView showUserProfilePage(){
        UserProfile userProfile = new UserProfile();
        ModelAndView modelAndView = new ModelAndView("user_profile");
        modelAndView.addObject("userProfile", userProfile);
        return modelAndView;
    }



}
