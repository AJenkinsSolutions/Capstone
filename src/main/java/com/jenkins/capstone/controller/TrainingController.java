package com.jenkins.capstone.controller;

import com.jenkins.capstone.model.Training;
import com.jenkins.capstone.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This Controller is responsible for handle
 * the user request from the view layer
 * @Author- Alex Jenkins
 */
@Controller
public class TrainingController {

    private TrainingService trainingService;
    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    /**
     * We are checking is display is equal to all if so we display all enumerated tags
     * filter through to only retireve trainings with corresponding type.
     * @param display
     * @param model
     * @return
     */
    @RequestMapping(value = "/training{display}")
    public String showView(@PathVariable String display, Model model) {
//        Controller logic
//        Parses the PathVariable
        if (display != null) {
            //Will add the appropriate Attribute to the model
            switch (display) {
                case "all":
                    ///code here
                    model.addAttribute("fundamentals", true);
                    model.addAttribute("essentials", true);
                    model.addAttribute("advanced", true);
                    model.addAttribute("development", true);
                    model.addAttribute("project", true);
                    break;
                case "fundamentals":
                    ///code here
                    model.addAttribute("fundamentals", true);
                    break;
                case "essentials":
                    ///code here
                    model.addAttribute("essentials", true);
                    break;
                case "advanced":
                    ///code here
                    model.addAttribute("advanced", true);
                    break;
                case "development":
                    ///code here
                    model.addAttribute("development", true);
                    break;
                case "project":
                    ///code here
                    model.addAttribute("project", true);
                    break;
                default:
                    ///code here
                    model.addAttribute("fundamentals", true);
                    model.addAttribute("essentials", true);
                    model.addAttribute("advanced", true);
                    model.addAttribute("development", true);
                    model.addAttribute("project", true);
                    break;
            }
        }
        //I want all the trainings
        List<Training> trainingsList = trainingService.getAllTrainingTypes();
        System.out.println("Debug: "+ trainingsList.get(1).getType());
        groupEnumByType(trainingsList, model);

        return "training";
    }

    /**
     * Taking this list of object training types
     * Using this sytnax to Perform a aggreate function and group the object by Type
     * @param trainingsList
     * @param model
     */
    public void groupEnumByType(List<Training> trainingsList, Model model){
        Map<String, List<Training>> trainingsByType = trainingsList.stream()
                .collect(Collectors.groupingBy(training -> training.getType().toString()));
        System.out.println("Debug " + trainingsByType);
        model.addAllAttributes(trainingsByType);
    }



}


