package com.exercise1.exercise1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DimensoesInvalidasException.class)
    public ResponseEntity<Map<String, Object>> handleDimensoesInvalidas(DimensoesInvalidasException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("erro", "Dimensões inválidas");
        body.put("mensagem", ex.getMessage());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Aqui você pode tratar outras exceções também
}
