package com.Aperion.E_commerce.Controller;

import com.Aperion.E_commerce.Model.Users;
import com.Aperion.E_commerce.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register( @RequestBody Users user){
        return service.register(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return service.login();
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello authenticated user";
    }

}
