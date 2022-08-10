package com.example.mslogin.service;

import com.example.mslogin.model.UserEntity;

public interface UserService {
  public UserEntity login(String token);
  public String token(String token);
}
