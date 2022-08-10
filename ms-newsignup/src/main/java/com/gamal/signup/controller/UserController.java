package com.gamal.signup.controller;


import com.gamal.signup.model.UserEntity;
import com.gamal.signup.model.UserRequest;
import com.gamal.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("sign-up")
    public ResponseEntity<UserEntity> signUp(@RequestBody @Valid UserRequest request){
        return ResponseEntity.ok(userService.signUp(request));
    }
}
