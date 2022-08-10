package com.gamal.signup.service.impl;

import com.gamal.signup.model.UserEntity;
import com.gamal.signup.model.UserException;
import com.gamal.signup.model.UserRequest;
import com.gamal.signup.repository.UserRepository;
import com.gamal.signup.service.UserService;
import com.gamal.signup.util.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository repository;
  @Autowired
  private BCryptPasswordEncoder bcryptEncoder;
  @Autowired
  private TokenHelper tokenHelper;

  @Override
  public UserEntity signUp(UserRequest request) {
    UserEntity entity = new UserEntity(request);
    entity.setPassword(bcryptEncoder.encode(entity.getPassword()));
    entity.setToken(tokenHelper.generateToken(entity));
    if (repository.findByEmail(entity.getEmail()).isPresent()) {
      throw new UserException(HttpStatus.BAD_REQUEST, "User already exists en the database");
    }
    UserEntity savedEntity = repository.save(entity);
    return savedEntity;
  }



}
