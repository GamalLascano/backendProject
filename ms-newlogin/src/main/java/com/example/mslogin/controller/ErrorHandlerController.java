package com.example.mslogin.controller;

import com.example.mslogin.model.CustomError;
import com.example.mslogin.model.UserException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomError error = new CustomError();
        error.setCodigo(HttpStatus.BAD_REQUEST.value());
        error.setDetail(ex.getBindingResult().getFieldError().getDefaultMessage());
        error.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<CustomError> handleUserNotFound(UserException ex){
        CustomError error = new CustomError();
        error.setCodigo(ex.getStatus().value());
        error.setDetail(ex.getMessage());
        error.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(error,ex.getStatus());
    }
}
