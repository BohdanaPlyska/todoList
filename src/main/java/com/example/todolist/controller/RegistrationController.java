package com.example.todolist.controller;

import com.example.todolist.entity.User;
import com.example.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    @PostMapping
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        if(userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("usernameError", "User with this name exist");
            return "registration";
        }
        return "redirect:/";
    }

}
