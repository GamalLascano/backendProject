package com.example.mslogin.service.impl;

import com.example.mslogin.model.UserEntity;
import com.example.mslogin.model.UserException;
import com.example.mslogin.repository.UserRepository;
import com.example.mslogin.service.UserService;
import com.example.mslogin.util.TokenHelper;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository repository;
  @Autowired
  private TokenHelper tokenHelper;
  @Override
  public UserEntity login(String token) {
    try {
      Optional<UserEntity> entity = tokenHelper.validateUser(token);
      if (entity.isPresent()) {
        UserEntity modifiedEntity = repository.findByEmail(entity.get().getEmail()).get();
        modifiedEntity.setToken(tokenHelper.generateToken(modifiedEntity));
        modifiedEntity.setIsActive(true);
        modifiedEntity.setLastLogin(Timestamp.from(Instant.now()));
        repository.save(modifiedEntity);
        return modifiedEntity;
      } else {
        throw new UserException(HttpStatus.NOT_FOUND, "User does not exist in the database");
      }
    } catch (UserException e) {
      throw new UserException(e.getStatus(), e.getMessage());
    }
  }

  @Override
  public String token(String token) {
    UserEntity entity = new UserEntity();
    entity.setEmail(token);
    return tokenHelper.generateToken(entity);
  }
}
