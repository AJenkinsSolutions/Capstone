package com.jenkins.capstone.validation;

import com.jenkins.capstone.decorators.InputValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class InputValueMatchValidator implements ConstraintValidator<InputValueMatch, Object> {

    /**
     * Define the inoput fields
     */
    private String input;
    private String inputMatch;


    @Override
    public void initialize(InputValueMatch constraintAnnotation) {
        this.input = constraintAnnotation.field();
        this.inputMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //Get the name of each input
        Object inputValue = new BeanWrapperImpl(value).getPropertyValue(input);
        Object inputMatchValue = new BeanWrapperImpl(value).getPropertyValue(inputMatch);
        // if they are equal it will run

        if(inputValue != null){
            return inputValue.equals(inputMatchValue);
        }else{
            return inputMatchValue == null;
        }
    }
}
