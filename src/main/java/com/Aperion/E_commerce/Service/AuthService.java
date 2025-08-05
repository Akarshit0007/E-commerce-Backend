package com.Aperion.E_commerce.Service;

import com.Aperion.E_commerce.Model.Users;
import com.Aperion.E_commerce.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
     UserRepo userrepo;
    @Autowired
     PasswordEncoder passwordEncoder;

    public ResponseEntity<String> register(Users user){
        if(userrepo.findByUsername(user.getUsername()).isPresent()){
            return
                    ResponseEntity.badRequest().body("Username Already Exist");
        }
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    userrepo.save(user);
    return ResponseEntity.ok("User Registered Succesfully");
    }

    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login Succesfully");
    }
}
