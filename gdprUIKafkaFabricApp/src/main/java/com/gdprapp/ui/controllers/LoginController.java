package com.gdprapp.ui.controllers;



import com.gdprapp.ui.orm.model.UserItem;
import com.gdprapp.ui.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
class LoginController {


    @Autowired
    UserService userService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView validateLoginCreds(@Valid UserItem user, BindingResult bindingResult, ModelMap model) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        boolean isValidUser = userService.isValidUserEmailAndPass(user);

        if (isValidUser){
            modelAndView.setViewName("journey");
            UserItem userItem = userService.findByUsername(user.getEmail());
            model.addAttribute("user",userItem);
            model.addAttribute("error",false);
        }else {
            model.addAttribute("error",true);
        }

        if (user.getUserType().equalsIgnoreCase("Manufacturer")){

            model.addAttribute("manufacturerMode",true);
            modelAndView.setViewName("journeyM");
        }

        model.addAttribute("showInput",true);
        return modelAndView;
    }

    @RequestMapping(value={"/register"}, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid UserItem userItem, BindingResult bindingResult, ModelMap model) {

        userService.save(userItem);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("journey");

        if (userItem.getUserType().equalsIgnoreCase("Manufacturer")){

            model.addAttribute("manufacturerMode",true);
            modelAndView.setViewName("journeyM");
        }

        model.addAttribute("user",userItem);
        model.addAttribute("showInput",true);

        return modelAndView;
    }
}