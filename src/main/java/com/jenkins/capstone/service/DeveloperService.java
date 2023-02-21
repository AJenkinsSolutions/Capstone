package com.jenkins.capstone.service;

import com.jenkins.capstone.constants.ProjectConstants;
import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.model.Roles;
import com.jenkins.capstone.repository.DeveloperRepository;
import com.jenkins.capstone.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
@Slf4j
@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private RoleRepository roleRepository;

    public DeveloperService() {
        System.out.println("DeveloperService bean created");
    }

    /**
     * We want to add this developer to the persistent layer
     * ROLE - NOT NULLABLE in our developer table
     * We HAVE to Set the role of a new Developer when we add them to the persistence layer
     * @param developer
     * @return
     */
    public boolean AddDeveloper(Developer developer){
        boolean saved = false;
        System.out.println("Debug" + developer.toString());
        //Get the role for our dev
        Roles role = roleRepository.getByRoleName(ProjectConstants.DEVELOPER_ROLE);
        System.out.println("Debug: Role got" + role);
//        //Set the role
        developer.setRoles(role);
        System.out.println("Debug: New dev role name " + developer.getRoles().getRoleName());
        //Use the repo layer to save our new developer
        Developer savedDeveloper = developerRepository.save(developer);
        System.out.println("Debug: New Saved dev details: " + savedDeveloper.toString());
        if(null != savedDeveloper && savedDeveloper.getDeveloperId() > 0){
            saved = true;
        }else{
            return saved;

        }
        return true;

    }
}
