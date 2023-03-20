package com.think.talent.test.thinktalenttest.controller;


import com.think.talent.test.thinktalenttest.processor.NameProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NameDisplayController
{

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model){
        System.out.println("NameDisplayController showWelcomePage Called");
        //model.addAttribute("message","Welcome to Name Display Page!!!");
        model.addAttribute("message","Hello !!! Welcome to Name Display Page !!!!Please Enter Name!!!!");
        return "welcome";
    }

    @RequestMapping(value="/displayName", method = RequestMethod.GET)
    public String displayName(ModelMap model, @RequestParam String firstName, @RequestParam String middleName,@RequestParam String lastName){
        System.out.println("NameDisplayController displayName Called"+firstName+middleName+lastName);
        if((firstName != null && !"".equals(firstName)) && (lastName != null && !"".equals(lastName))){
            NameProcessor nameProcessor = new NameProcessor();
            String nameToDisplay="Full Name : "+nameProcessor.getNameToDisplay(firstName,middleName,lastName);
            System.out.println("Name for Display-->"+nameToDisplay);
            model.addAttribute("message",nameToDisplay);
            return "welcome";
        }else{
            model.put("message","FirstName and LastName are Mandatory and cannot be blank");
            return "welcome";
        }
    }
}
