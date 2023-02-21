package com.jenkins.capstone.validation;

import com.jenkins.capstone.decorators.PasswordStrength;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ConstraintValidator: Generic is our password annotation interface,
 * plus the field type
 *
 */
public class PasswordStrengthValidator implements ConstraintValidator<PasswordStrength, String > {

    //Our list of weak passwords
    List<String> weakPasswords;


    /**
     * Initalize the starting data
     * @param passwordStrength
     */
    @Override
    public void initialize(PasswordStrength passwordStrength) {
        weakPasswords = Arrays.asList("123456", "password", "qwerty", "abc123", "letmein",
                "admin", "iloveyou", "monkey", "login", "welcome", "football", "starwars", "princess",
                "sunshine", "master");
    }

    /**
     * Check if null
     * check if it matches a weakpassord
     * @param passwordField - poassword eneterd by user
     * @param constraintValidatorContext - interface inside the javax execution libary
     * As long as the password isn't null and doesn't macth a weak password we will return true meaning the validation is successful
     * @return
     */
    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        return passwordField != null && (!weakPasswords.contains(passwordField));
    }
}
