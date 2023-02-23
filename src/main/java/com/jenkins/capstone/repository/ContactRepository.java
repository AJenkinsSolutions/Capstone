package com.jenkins.capstone.repository;

import com.jenkins.capstone.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Contact findByStatus(String status);

    Contact findByEmail(String email);
}
