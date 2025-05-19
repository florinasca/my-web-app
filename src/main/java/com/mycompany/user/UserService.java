package com.mycompany.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static jdk.internal.org.jline.utils.Colors.s;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public String ListAll() {
        List<User> listUsers = (List<User>) repo.findAll();
        //model.addAttribute("listUsers", listUsers);
        return "users";
    }

    public void listAll() {
    }
}

