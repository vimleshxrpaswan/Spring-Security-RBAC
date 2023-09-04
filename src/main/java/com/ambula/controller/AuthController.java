package com.ambula.controller;

import com.ambula.dto.UserCredentials;
import com.ambula.entities.UserEntity;
import com.ambula.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserEntity userEntity) {
        return userService.registerUser(userEntity);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserCredentials userCredentials) {
        return userService.login(userCredentials);
    }
}
