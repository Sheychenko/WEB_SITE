package com.example.demo.Controllers;

import com.example.demo.User.UserService;
import com.example.demo.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userService.authentication(username, password);
        if (user != null) {
            return "profile";
        } else  {
            return "incorrect_password_or_login";
        }
    }
}
