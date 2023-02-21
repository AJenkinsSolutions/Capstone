package com.jenkins.capstone.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.AuthenticationException;

public class Authentication implements AuthenticationProvider {
    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
