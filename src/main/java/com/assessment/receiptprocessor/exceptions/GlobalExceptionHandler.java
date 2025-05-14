package com.assessment.receiptprocessor.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("description", "The receipt is invalid.");
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String,String>> handleIllegalStateException(IllegalStateException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("description", "No receipt found for that ID.");
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
