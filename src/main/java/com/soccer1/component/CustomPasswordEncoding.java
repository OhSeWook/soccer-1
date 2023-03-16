package com.soccer1.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoding {
 
    public String sha256Encoding(String password) {
        String encPassword = "";
        encPassword = passwordEncoder("bcrypt").encode(password);
        //encPassword = encPassword.replace("{sha256}", "");
        return encPassword;
    }
 
    public PasswordEncoder passwordEncoder(String type) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(type, encoders);
    }
 
    public boolean sha256Matching(String password, String encPassword) {
        //encPassword = "{sha256}"+encPassword;
        return passwordEncoder("bcrypt").matches(password, encPassword);
    }
 
 
}