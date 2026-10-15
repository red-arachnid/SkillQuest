package com.skillearn.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice 
public class AppExceptionHandler {
    
    // If any custom exception were thrown this will be called
    // Returning the message givne in throw new ApiException
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleApi(ApiException exception) {
        return ResponseEntity.status(exception.getHttpStatus()).body(Map.of("message", exception.getMessage()));
    }

    // Called if the fields are incoorect 
    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException exception) {
        Map<String, String> fieldErrors = new HashMap<String, String>();
        
        exception.getBindingResult().getFieldErrors()
            .forEach(e -> fieldErrors.putIfAbsent(e.getField(), e.getDefaultMessage()));
        
        return ResponseEntity.badRequest().body(Map.of("message", "Validation failed", "errors", fieldErrors));
    }
}
