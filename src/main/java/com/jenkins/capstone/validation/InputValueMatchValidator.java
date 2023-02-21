package com.jenkins.capstone.validation;

import com.jenkins.capstone.decorators.InputValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class InputValueMatchValidator implements ConstraintValidator<InputValueMatch, Object> {

    /**
     * Define the inoput fields
     */
    private String field;
    private String fieldMatch;


    @Override
    public void initialize(InputValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //Get the name of each input
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        // if they are equal it will run

        if(fieldValue != null){
            return fieldValue.equals(fieldMatchValue);
        }else{
            return fieldMatchValue == null;
        }
    }
}
