package com.gamal.signup.service;

import com.gamal.signup.model.UserEntity;
import com.gamal.signup.model.UserRequest;

public interface UserService {
    public UserEntity signUp(UserRequest request);

}
