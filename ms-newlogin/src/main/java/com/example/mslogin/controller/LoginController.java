package com.example.mslogin.controller;

import com.example.mslogin.model.UserEntity;
import com.example.mslogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class LoginController {
  @Autowired
  private UserService userService;
  @PostMapping("login")
  public ResponseEntity<UserEntity> login(@RequestParam(name = "token")String token){
    return ResponseEntity.ok(userService.login(token));
  }
  @GetMapping("hello")
  public ResponseEntity<String> helloworld(){
    return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
  }
}
