package org.microservice.userservice.Exceptions;


import org.microservice.userservice.PayLoad.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.http.HttpResponse;

@RestControllerAdvice
public class GlobalExceptionsHandler {


    @ExceptionHandler(UserNotFoundExceptions.class)
    public ResponseEntity<ApiResponse> handlerResourcesNotFoundException(UserNotFoundExceptions userNotFoundExceptions){
        //ResponseEntity will hold data(error message)   and responseStatus Code

        String message = userNotFoundExceptions.getMessage();

        ApiResponse apiResponse = ApiResponse.builder()
                .message(message)
                .httpStatus(HttpStatus.NOT_FOUND)
                .success(true).build();

        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
