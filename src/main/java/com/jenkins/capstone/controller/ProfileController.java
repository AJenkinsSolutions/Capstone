package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.model.UserProfile;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

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
