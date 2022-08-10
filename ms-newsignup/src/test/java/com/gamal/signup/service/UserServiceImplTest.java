package com.gamal.signup.service;

import com.gamal.signup.util.TokenHelper;
import com.gamal.signup.model.UserEntity;
import com.gamal.signup.model.UserRequest;
import com.gamal.signup.repository.UserRepository;
import com.gamal.signup.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class UserServiceImplTest {
    @MockBean
    private BCryptPasswordEncoder bcryptEncoder;
    @MockBean
    private TokenHelper tokenHelper;
    @MockBean
    private UserRepository repository;
    @InjectMocks
    private UserServiceImpl userService;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSignUp(){
        Mockito.when(tokenHelper.generateToken(any())).thenReturn("obfuscatedtoken");
        Mockito.when(bcryptEncoder.encode(any())).thenReturn("encodedpwd");
        Mockito.when(repository.findByEmail(anyString())).thenReturn(Optional.empty());
        Mockito.when(repository.save(any())).thenReturn(createFinalUser());
        Assertions.assertEquals(createFinalUser(),userService.signUp(createUser()));
    }
    @Test
    void testLogin(){
        /*Mockito.when(tokenHelper.validateUser(anyString())).thenReturn(Optional.of(createEntity()));
        Mockito.when(tokenHelper.generateToken(any())).thenReturn("newtoken");
        Mockito.when(repository.save(any())).thenReturn(createEntity());
        Assertions.assertEquals("newtoken",userService.login("oldtoken").getToken());*/
    }
    private UserRequest createUser(){
        UserRequest entity = new UserRequest();
        entity.setPassword("pwd");
        entity.setEmail("a@b.com");
        return entity;
    }

    private UserEntity createEntity(){
        UserEntity entity = new UserEntity();
        entity.setPassword("pwd");
        entity.setEmail("a@b.com");
        return entity;
    }
    private UserEntity createFinalUser(){
        UserEntity entity = new UserEntity();
        entity.setPassword("encodedpwd");
        entity.setEmail("a@b.com");
        entity.setToken("obfuscatedtoken");
        return entity;
    }
}
