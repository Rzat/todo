package com.example.todo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        for (int i = 1; i < 10; i++) {
            String encodedString = passwordEncoder.encode("password@123");
            System.out.println(encodedString);
        }
    }

}
