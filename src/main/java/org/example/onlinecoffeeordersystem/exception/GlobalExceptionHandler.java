package org.example.onlinecoffeeordersystem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public Response handlerRuntimeException(RuntimeException e){
        return Response.fail(e.getMessage());
    }
}

