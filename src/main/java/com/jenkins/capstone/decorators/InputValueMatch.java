package com.jenkins.capstone.decorators;

import com.jenkins.capstone.validation.InputValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * We will use this to make sure to value fields are matching
 * @Target: ElementType.TYPE - this will make it work on top of a pojo class
 * @Retention: Basically this annotation will only be available during runtime
 * @Constraint: points to where the business logic lives for the actually validation
 */
@Constraint(validatedBy = InputValueMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InputValueMatch {

    /**
     * Boilerplate code for custom annotations
     * @return
     *
     */
    //This would be used if we wanted to group annotations
    Class <?>[] groups() default {};
    //if we want a certain response in a payload whenever a payload fails
    Class <? extends Payload>[] payload() default {};

    String message() default "Inputs do not match";

    /**
     * input 1
     * @return
     */
    String field();

    /**
     * input 2
     * @return
     */
    String fieldMatch();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        InputValueMatch[] value();
    }
}
