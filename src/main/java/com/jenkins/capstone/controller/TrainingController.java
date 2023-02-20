package com.jenkins.capstone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This Controller is responsible for handle
 * the user request from the view layer
 * @Author- Alex Jenkins
 */
@Controller
public class TrainingController {

    @RequestMapping(value = "/training")
    public String showView(){

        return "training";
    }


}

