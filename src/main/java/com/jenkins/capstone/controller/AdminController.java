package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.model.Project;
import com.jenkins.capstone.repository.DeveloperRepository;
import com.jenkins.capstone.repository.ProjectRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    DeveloperRepository developerRepository;





    @RequestMapping("/showProjectView")
    public ModelAndView showProjectsView(){
        List<Project> projectList = projectRepository.findAll();        ModelAndView modelAndView = new ModelAndView("admin_projects");
        modelAndView.addObject("projectList", projectList);
        modelAndView.addObject("project", new Project());
        return modelAndView;
    }
    @PostMapping("/addNewProject")
    public ModelAndView addNewProject(@Valid @ModelAttribute ("project") Project newProject, Errors error, Model model){
        projectRepository.save(newProject);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/showProjectView");
        return modelAndView;
    }

    /**
     * We want to remove the Fk class_id for all the students in the class we are trying to delte
     * set it to null then update/save each person back into the persistence layer
     * then we use the id we reteived from the view layer to to find the class in the db
     * then we simply remove that class
     * note we don't have to worry about fucking up of database because we removed to fk reference from each person associated with said class
     * @param
     * @param id
     * @return
     */
    @RequestMapping("deleteProject")
    public  ModelAndView deleteProject(@ModelAttribute("id") int id){
//        we have to remove each developers project value manaully or it will break db
        Optional<Project> projectList = projectRepository.findById(id);
        //Optional requires .get() to get the entity
        for(Developer projectMember : projectList.get().getDeveloperList()){
            //Removes the link between the dev and the project
            projectMember.setProject(null);
            developerRepository.save(projectMember);
        }

        projectRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/showProjectView");
        return modelAndView;
    }
    @RequestMapping("/showAllDevs")
    public ModelAndView showAllDevs(@RequestParam int projectId,@RequestParam(value = "error", required = false) String error, HttpSession session){
        String errorMsg = null;


        ModelAndView modelAndView = new ModelAndView("admin_project_devs");
        Optional <Project> project = projectRepository.findById(projectId);
        modelAndView.addObject("project", project.get());
        modelAndView.addObject("developer", new Developer());
        session.setAttribute("currentProject", project.get());
        if(error != null){
            errorMsg = "Invalid Email";
            modelAndView.addObject("errorMsg", errorMsg);
        }
        return modelAndView;
    }

    @PostMapping("/addDevToProject")
    public ModelAndView addDevToProject(@ModelAttribute("developer") Developer developer, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
//        we trying to add get the dev from db we are trying to add
        Project project = (Project) session.getAttribute("currentProject");
        Developer developerObj = developerRepository.findByEmail(developer.getEmail());

        if(developerObj == null || !(developerObj.getDeveloperId() > 0) ){
            modelAndView.setViewName("redirect:/admin/showAllDevs?projectId="+project.getProjectId() + "&error=true");
            return modelAndView;
        }
        //link the student with the class
        developerObj.setProject(project);
        developerRepository.save(developerObj);

        project.getDeveloperList().add(developerObj);
        projectRepository.save(project);
        ModelAndView modelAndView1 = new ModelAndView("redirect:/admin/showAllDevs?projectId="+ project.getProjectId());
        return modelAndView;
    }
















}
