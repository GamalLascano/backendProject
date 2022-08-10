package com.example.backend.client;

import com.example.backend.model.UserEntity;
import com.example.backend.model.UserRequest;
import javax.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("ms-signup")
public interface UserSignupClient {
  @PostMapping("sign-up")
  UserEntity signUp(@RequestBody @Valid UserRequest request);
}
