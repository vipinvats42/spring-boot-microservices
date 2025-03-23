package com.eazybytes.accounts.service.impl;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.accounts.dto.ErrorResponseDTO;
import com.eazybytes.accounts.exception.CustomerAlreadyException;


/**
 * @Author: vipin tyagi
 * ControllerAdvice : where there is any exception in the application (globally in any any controller) it will be handled here
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(CustomerAlreadyException.class) 
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyException(CustomerAlreadyException exception,
    WebRequest webRequest){ 
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.BAD_REQUEST,
            exception.getMessage(),
            LocalDateTime.now()
            );
            return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
