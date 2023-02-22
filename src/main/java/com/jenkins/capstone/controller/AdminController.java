package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {



    @RequestMapping("/showProjectView")
    public ModelAndView showProjectsView(){

        ModelAndView modelAndView = new ModelAndView("admin_projects");
        modelAndView.addObject("project", new Project());
        return modelAndView;
    }

}
