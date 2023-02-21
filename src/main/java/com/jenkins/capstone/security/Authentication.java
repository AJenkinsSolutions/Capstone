package com.jenkins.capstone.security;

import com.jenkins.capstone.model.Developer;
import com.jenkins.capstone.model.Roles;
import com.jenkins.capstone.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Component
public class Authentication implements AuthenticationProvider {


    @Autowired
    private DeveloperRepository developerRepository;

    /**
     * Authentication obj will get the Username and Password
     * then perform business logic / persistence logic
     * hand off authToken if successfull return else null
     * @param authentication the authentication request object.
     * @return
     * @throws AuthenticationException
     * Auther Alex jenkins
     * 02/21/23
     * Sources - https://www.baeldung.com/spring-security-authentication-provider
     */
    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        //TODO - DB logic
        //TODO - add this as service clas after its working
        Developer developer = developerRepository.findByEmail(email);
        if(developer != null && developer.getDeveloperId() >0 && developer.getPwd().equals(pwd)){
            return new UsernamePasswordAuthenticationToken(
                   //Spring will remove the pwd post authentication
                    developer.getName(), null, getGrantedAuthorites(developer.getRoles()));
        }else{
            throw new BadCredentialsException("Invalid credentials");
        }



    }

    /**
     * We are are creating a new SimpleGrantedAuthority object from the Authentication provider implementation
     * We use the param to access the getters and setters or the DEVELOPER object anf get the Roles within
     * @param roles
     * @return
     * Sources - https://www.baeldung.com/spring-security-granted-authority-vs-role
     */
    public List<GrantedAuthority> getGrantedAuthorites(Roles roles){
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE" + roles.getRoleName()));


        return
    }

    /**
     * We just have to tell this method what 'type' authentication this is
     * in this case its Username && Password type
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return
    }
}
