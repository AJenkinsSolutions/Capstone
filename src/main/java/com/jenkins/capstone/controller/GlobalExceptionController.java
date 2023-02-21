package com.jenkins.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * This gives the ability to handle cross-cutting concerns
 * @ControllerAdvice gives the ability to handle exceptions across our whole application
 * interceps our methods
 * Author Alex - Jenkins
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * this will display our 404 error view when an expection is thrown
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception){
        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errorMsg", exception.getMessage());
        return errorPage;
    }

}
