package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping(value = {"/contact"})
    public String showContactView(Model model){
        model.addAttribute("contact", new Contact());
        return null;
    }

}
