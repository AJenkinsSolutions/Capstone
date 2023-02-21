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
     * We want to display the contatct form view
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

}
