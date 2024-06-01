package com.example.demo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static String encode(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }
//    public static boolean compareHashes(String hashedPassword1, String hashedPassword2) {
//        return hashedPassword1.equals(hashedPassword2);
//    }
}
