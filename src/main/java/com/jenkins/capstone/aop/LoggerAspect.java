package com.jenkins.capstone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * This class will use the principles of AOP to manage
 * Cross Cutting concerns such as logging and exception logging
 * @Author: Alex P Jenkins
 * @Date: 02/20/23
 * @Version: SnapShot 1
 * @Capstone
 */
@Slf4j
@Aspect
@Component
public class LoggerAspect {

    /**
     * This Aspect will trigger everytime a Execption is thrown
     * @param joinPoint : In Aspect-Oriented Programming (AOP), a join point is a point in the execution of a program where an aspect can be applied.
     * @param ex
     * @Author: Alex P Jenkins
     * @Date: 02/20/23
     * @Version: SnapShot 1
     * @Capstone
     */
    @AfterThrowing(value = "execution(* com.jenkins.capstone..*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        log.error(joinPoint.getSignature() + "An exeception happened due to: " + ex.getMessage());
    }


    /**
     * This Aspect will log when the time is takes for a method to execute
     * @param joinPoint:
     * @return
     * @throws Throwable
     * @Author: Alex P Jenkins
     * @Date: 02/20/23
     * @Version: SnapShot 1
     * @Capstone
     */
    @Around("execution(* com.jenkins.capstone..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        //Log
        log.info(joinPoint.getSignature().toString() + " Method execution start");
        //Timing
        Instant start = Instant.now();
        //Proceed makes sure the actually buisness logic will happen
        //We have to make sure we are returning the same object as the methods
        //So we define the return Object as Object
        Object returnObject = joinPoint.proceed();
        //Get current time
        Instant finsih = Instant.now();
        //Calculate time taken
        long timeElasped = Duration.between(start, finsih).toMillis();
        log.info("Execution time " + joinPoint.getSignature().toString() + "method i s: " + timeElasped);
        log.info(joinPoint.getSignature().toString() + "method:execution end" );
        return returnObject;
    }



}
