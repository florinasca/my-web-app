package com.mycompany.user;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static jdk.internal.org.jline.utils.Colors.s;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public String showUsersList(Model model) {
        service.listAll();
        return "users";
    }

    @GetMapping( "/users/new")
    public String showNewUserForm(Model model) {
        model.addAttribute(s: users, new Users());
        return "user_form";
    }

}
