package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Contact;
import com.jenkins.capstone.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
        System.out.println("ContactService Bean add to the IoC");
    }


    /**
     * We want to display the contact form view
     * we send a contact pojo to the field to be populated with the values
     * from the form fields using Thymeleaf
     * @param model
     * @return
     * @Author - Alex Jenkins
     */
    @RequestMapping(value = {"/contact"})
    public String showContactView(Model model){
        model.addAttribute("contact", new Contact());
        return null;
    }

    /**
     * We want to save the message to the persistent layer
     * We @Valid to see if the form was valid
     * We 'pick up' the contact Object we handed to the model in pervious method
     * If no errors we save the message to the persistent layer
     * and redirect the user back to the clean contact screen
     * @param contact - pojo we handed off to the view layer
     * @param errors - if the form has errors we display the same page handing down the errors
     * @return
     */
    @RequestMapping(value = "/saveMsg", method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        //check if the form is invalid
        if(errors.hasErrors()){
            log.error("Contact from failed due to" + errors.toString());
            return "contact";
        }
        contactService.addMessageToInbox(contact);
        return "redirect:/contact";
    }


    @RequestMapping("/showInboxView")
    public ModelAndView showInboxView(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("inbox");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }

    /**
     * We need to retreive the id from the message we want to close
     * @param id catching the id from the query param
     * @return
     */
    @RequestMapping(value = "/closeMsg",method = GET)
    public String closeMsg(@RequestParam int id) {

        contactService.updateMsgStatus(id);
        //Refresh the page
        return "redirect:/showInboxView";
    }



}
