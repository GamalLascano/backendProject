package com.example.backend.controller;

import com.example.backend.client.UserLoginClient;
import com.example.backend.client.UserSignupClient;
import com.example.backend.model.CustomError;
import com.example.backend.model.UserEntity;
import com.example.backend.model.UserRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.sql.Timestamp;
import java.time.Instant;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class UserController {
  @Autowired
  private UserLoginClient userLoginClient;
  @Autowired
  private UserSignupClient userSignupClient;

  @GetMapping("hello")
  @CircuitBreaker(name="hello",fallbackMethod = "catchError")
  public ResponseEntity<String> helloworld(){
    return ResponseEntity.ok(userLoginClient.helloWorld());
  }
  @PostMapping("login")
  @CircuitBreaker(name="login",fallbackMethod = "catchError")
  public ResponseEntity<UserEntity> login(@RequestParam(name = "token")String token){
    return ResponseEntity.ok(userLoginClient.login(token));
  }
  public ResponseEntity<CustomError> catchError(Throwable throwable){
    CustomError error = new CustomError();
    error.setTimestamp(Timestamp.from(Instant.now()));
    error.setCodigo(400);
    error.setDetail(throwable.getCause().toString());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
  @PostMapping("signup")
  @CircuitBreaker(name="signup",fallbackMethod = "catchError")
  public ResponseEntity<UserEntity> signUp(@RequestBody @Valid UserRequest request){
    return ResponseEntity.ok(userSignupClient.signUp(request));
  }
}
