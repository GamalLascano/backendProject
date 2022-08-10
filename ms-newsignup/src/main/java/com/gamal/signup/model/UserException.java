package com.gamal.signup.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
public class UserException extends RuntimeException {
    private HttpStatus status;
    public UserException(HttpStatus status, String message){
        super(message);
        this.status=status;
    }
}
