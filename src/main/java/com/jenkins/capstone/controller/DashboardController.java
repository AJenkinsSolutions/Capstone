package com.jenkins.capstone.controller;

import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This will handel user request with dashboard
 */
@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String showDashboardView(Model model, Authentication authentication, HttpSession session){
        return "dashboard";
    }

}
