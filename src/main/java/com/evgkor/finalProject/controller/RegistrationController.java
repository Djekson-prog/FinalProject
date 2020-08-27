package com.evgkor.finalProject.controller;

import com.evgkor.finalProject.bean.User;
import com.evgkor.finalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registration(Model model){
        model.addAttribute("userForm",new User());
        return "register";
    }
    @PostMapping("/register")
    public String addUser(@ModelAttribute("userForm") @Validated User userForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "User with that name already exist");
            return "register";
        }
        return "redirect:/login";
    }
}
