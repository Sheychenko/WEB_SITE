package com.example.demo.Controllers;

import com.example.demo.security.PasswordEncoder;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.demo.User.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @GetMapping("/register")
    public String register(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        logger.info("SADSADSAFSAFSAFSAFASFAFSAFSAFSAFSAFSAFSAFA:" + username);
        if (username == null) {
            return "register";
        } else {
            model.addAttribute("message", "Registration successful for username: " + username);
            return "register_success";
        }
    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String login, @RequestParam String password, Model model, HttpSession session) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        userService.registerUser(login, encodedPassword);
        session.setAttribute("username", login);
        logger.info("SADSdDDFFFFFFFFFFFFFFFFADSAFSAFSAFSAFASFAFSAFSAFSAFSAFSAFSAFA:" + (String) session.getAttribute("username"));
        model.addAttribute("message", "Registration successful for username: " + login);
        return "register_success";
    }
}
