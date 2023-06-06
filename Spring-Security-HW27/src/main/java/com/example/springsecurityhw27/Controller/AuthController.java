package com.example.springsecurityhw27.Controller;


import com.example.springsecurityhw27.Model.MyUser;
import com.example.springsecurityhw27.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
       List<MyUser>  myUsers = authService.getAllUsers();
        return ResponseEntity.status(200).body(myUsers);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(200).body("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity login(){

        return ResponseEntity.status(200).body("login");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(){

        return ResponseEntity.status(200).body("logout");
    }
    @PostMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.status(200).body("welcome user");
    }
}
