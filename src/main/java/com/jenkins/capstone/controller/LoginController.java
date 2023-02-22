package com.jenkins.capstone.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String showLoginView(@RequestParam(required = false, value = "error")String error,
                                @RequestParam(required = false, value = "logout")String logout,
                                @RequestParam(required = false, value = "signup")String signup,
                                Model model){
        String alertMsg = null;
        //Depending on the contents of our optional Request Params
        //Alert - danger || success || info
        if(error != null){
            alertMsg = "Username Or passward wrong";
        } else if (logout != null){
            alertMsg = "Youve been logged out";
        } else if (signup != null){
            alertMsg = "Registration Complete!!!, Login with new credentials";
        }
        //Add it to the model
        model.addAttribute("alertMsg", alertMsg);
        return "/login";
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }




}
