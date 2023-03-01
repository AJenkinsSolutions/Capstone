package com.jenkins.capstone.service;

import com.jenkins.capstone.constants.ProjectConstants;
import com.jenkins.capstone.model.Contact;
import com.jenkins.capstone.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {


    private ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public Contact addMessageToInbox(Contact contact){
        boolean saveComplete = false;
        //Set to Open By default
        contact.setStatus(ProjectConstants.OPEN);
        contact.setCreatedAt(LocalDateTime.now());
        Contact savedContact = contactRepository.save(contact);

        if(savedContact != null && savedContact.getContactId() >0){
            saveComplete = true;
        }
        return savedContact;
    }

    //Custom Queries /Derived Query methods Custom where conditions
    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(ProjectConstants.OPEN);
        return contactMsgs;
    }

    /**
     * Invoking our method from our repository
     * what message, and the new status, and who wants to update it
     * @param contactId: Primary key value
     * @param
     * @return
     */
    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;
        //Becuase this can sometimes return null we use optional to catch it
        Optional<Contact> contactObj = contactRepository.findById(contactId);
        //Using the contact object we can make the updates we need
        contactObj.ifPresent(contact1 -> {
            //Update status to closed
            contact1.setStatus(ProjectConstants.CLOSE);
        });
        //Then we will pass the updated contact object to the save method from teh CrudRepository
        //Because the contact is optional we need to use .get()
        //Spring will know that we want to update the object not replace
        Contact updatedContact = contactRepository.save(contactObj.get());
        //Checking to see if my updated object is not null meaning our update is successful
        if(null != updatedContact && updatedContact.getUpdatedBy()!=null) {
            //Flipping our switch
            isUpdated = true;
        }
        return isUpdated;
    }




}
