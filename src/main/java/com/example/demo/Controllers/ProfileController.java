package com.example.demo.Controllers;

import com.example.demo.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @Autowired
    private  UserService userService;

    @PostMapping("/profile")
    public String updateProfile(@RequestParam String username, @RequestParam MultipartFile file) {
        try {
            byte[] photoData = file.getBytes();
            userService.saveProfilePhoto(username, photoData);
            return "Uploaded_successful";

        } catch (IOException e) {
            return "Uploaded_unsuccessfully" + e.getMessage();
        }
    }
}
