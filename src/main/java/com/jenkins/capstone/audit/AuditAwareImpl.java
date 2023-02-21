package com.jenkins.capstone.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * This class incorporates the principles of auditing in spring provides us with information about which user is performing certain actions
 * The method either returns Optional or a String representing the current user
 * Author - Alex Jenkins
 * Capstone
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * SpringContextHolder: thos repersents the users security context,
     * getName(), Authentication
     * Optional: If user is not authentication the value will be nulll. user is annoyomus
     * spring security context will hold this info
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        //Identify who is the current user trying to perfrom a certin action

        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
