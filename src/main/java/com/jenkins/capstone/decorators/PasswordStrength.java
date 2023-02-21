package com.jenkins.capstone.decorators;


import com.jenkins.capstone.validation.PasswordStrengthValidator;
import jakarta.persistence.Table;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * This custom validator will only run on One Field in our signup form
 * @Target refers to where the annotation can be used
 *
 */
@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordStrength {

    /**
     * Boilerplate code for custom annotations
     * @return
     *
     */
    //This would be used if we wanted to group annotations
    Class <?>[] groups() default {};
    //if we want a certain response in a payload whenever a payload fails
    Class <? extends Payload>[] payload() default {};

    //This is the default message.
    // Display to user whenever certain validation fails

    /**
     * Default message we display if validation fails
     * @return
     */
    String message() default "The password is weak-sauce bro choose a better one ";
}
