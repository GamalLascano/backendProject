package com.gamal.signup.controller;

import com.gamal.signup.model.UserEntity;
import com.gamal.signup.model.UserRequest;
import com.gamal.signup.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class UserControllerTest {
    @MockBean
    private UserService userService;
    @InjectMocks
    private UserController userController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testSignUp(){
        Mockito.when(userService.signUp(any())).thenReturn(createEntity());
        Assertions.assertEquals(userController.signUp(createUser()), ResponseEntity.ok(createEntity()));
    }
    @Test
    void testLogin(){
       /* Mockito.when(userService.login(anyString())).thenReturn(createEntity());
        Assertions.assertEquals(userController.login("token"), ResponseEntity.ok(createEntity()));*/
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
}
