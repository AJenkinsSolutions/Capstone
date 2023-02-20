package com.jenkins.capstone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This Config class will handle *Static WebPages
 * *They do not require user Input or dynmaic data
 *
 * @Author: Alex P Jenkins
 * @Date: 02/20/23
 * Version: SnapShot 1
 *
 */
@Configuration
public class WebStaticConfig implements WebMvcConfigurer {

    /**
     * Define the objects assigned to the static view
     * @param registry: simply helps us register static views: Object of the ViewControllerRegistry
     * @Author: Alex P Jenkins
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/about").setViewName("about");
    }




}
