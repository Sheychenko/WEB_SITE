package com.example.demo.User;
import com.example.demo.model.User;

import com.example.demo.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public void registerUser(String username, String encodedPassword) {
        User user = new User();
        user.setUsername(username);
        user.setEncodedPassword(encodedPassword);
        userRepository.save(user);
    }
    public User authentication(String username, String password) {
        User user = userRepository.findByUsername(username);
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        if (user.getEncodedPassword().equals(encodedPassword) && user != null) {
            return user;
        } else {
            return null;
        }
    }
    public void saveProfilePhoto(String name, byte[] photo) {
        User user = userRepository.findByUsername(name);
        user.setProfilePhoto(photo);
        userRepository.save(user);
    }
    public byte[] getProfilePhoto(String name) {
        User user = userRepository.findByUsername(name);
        if (user != null) {
            return user.getProfilePhoto();
        } else {
            return null;
        }
    }
    public static boolean matches(String rawPassword, String userPassword) {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        return encoder.matches(encodedPassword, userPassword);
    }
}

