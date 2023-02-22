package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.model.Skills;
import com.jenkins.capstone.model.UserProfile;
import com.jenkins.capstone.repository.DeveloperRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    DeveloperRepository developerRepository;

    /**
     * Session management
     * Uses the session object to populate the fields
     * .getAttribute
     * Displays the user profile view
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/showUserProfileView", method = RequestMethod.GET)
    public ModelAndView showUserProfilePage(HttpSession session){

        Developer loggedUser = (Developer) session.getAttribute("currentLoggedUser");
        UserProfile userProfile = new UserProfile();

        //Add users details to the form
        configureProfileFormBase(loggedUser, userProfile);

        //Get skills information / Check if not mandatory skill exists
        if(loggedUser.getSkills() != null && loggedUser.getSkills().getSkillsId() > 0){
            configureProfileFormSkills(loggedUser, userProfile);
        }

        //Add model and view
        ModelAndView modelAndView = new ModelAndView("user_profile");
        modelAndView.addObject("userProfile", userProfile);


        return modelAndView;
    }

    @PostMapping(value = "/updateProfile")
    public String updateProfile(@Valid @ModelAttribute("userProfile") UserProfile userProfile, HttpSession session, Errors errors){
        if(errors.hasErrors()){
            return "user_profile";
        }
        Developer loggedUser = (Developer)session.getAttribute("currentLoggedUser");

        //update the loggedUser pojo
        loggedUser.setName(userProfile.getName());
        loggedUser.setEmail(userProfile.getEmail());
        loggedUser.setMobileNumber(userProfile.getMobileNumber());
        //If logged user has no skills information we will add a empty table to db
        if(loggedUser.getSkills() == null || loggedUser.getSkills().getSkillsId() < 1){
            loggedUser.setSkills(new Skills());
        }
//        update skills
        loggedUser.getSkills().setLanguage(userProfile.getLanguage());
        loggedUser.getSkills().setFrontEnd(userProfile.isFrontEnd());
        loggedUser.getSkills().setBackEnd(userProfile.isBackEnd());
        loggedUser.getSkills().setIde(userProfile.getIde());
//        persistent logic
        developerRepository.save(loggedUser);
        session.setAttribute("currentLoggedUser", loggedUser);
        return "redirect:/showUserProfileView";

    }





    //CustomUtilityOperations
    /**
     * This is helper method to populate the profile form with data from the session user
     * @param loggedUser
     * @param profileForm
     * @return
     * Author - Alex Jenkins
     */
    public void configureProfileFormSkills(Developer loggedUser, UserProfile profileForm){

        profileForm.setLanguage(loggedUser.getSkills().getLanguage());
        profileForm.setFrontEnd(loggedUser.getSkills().isFrontEnd());
        profileForm.setBackEnd(loggedUser.getSkills().isBackEnd());
        profileForm.setIde(loggedUser.getSkills().getIde());

    }

    /**
     * This helper method populates the profile form with the base values from the sessions user pojo
     * @param loggedUser
     * @param profileForm
     */
    public void configureProfileFormBase(Developer loggedUser, UserProfile profileForm){
        profileForm.setName(loggedUser.getName());
        profileForm.setEmail(loggedUser.getEmail());
        profileForm.setMobileNumber(loggedUser.getMobileNumber());
    }

}
