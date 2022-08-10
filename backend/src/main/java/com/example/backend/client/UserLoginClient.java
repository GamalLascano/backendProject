package com.example.backend.client;

import com.example.backend.model.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ms-login")
public interface UserLoginClient {
  @GetMapping("hello")
  String helloWorld();
  @PostMapping("login")
  UserEntity login(@RequestParam(name = "token") String token);

}
