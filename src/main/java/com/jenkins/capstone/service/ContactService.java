package com.jenkins.capstone.service;

import com.jenkins.capstone.constants.ProjectConstants;
import com.jenkins.capstone.model.Contact;
import com.jenkins.capstone.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {


    private ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public boolean addMessageToInbox(Contact contact){
        boolean saveComplete = false;
        //Set to Open By default
        contact.setStatus(ProjectConstants.OPEN);
        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);

        if(savedContact != null && savedContact.getContactId() >0){
            saveComplete = true;
        }
        return saveComplete;
    }


}
