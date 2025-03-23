package com.eazybytes.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.accounts.dto.ErrorResponseDTO;


/**
 * @Author: vipin tyagi
 * ControllerAdvice : where there is any exception in the application (globally in any any controller) it will be handled here
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ResourceNotfoundexception.class) 
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundEception(ResourceNotfoundexception exception,
    WebRequest webRequest){ 
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.NOT_FOUND,
            exception.getMessage(),
            LocalDateTime.now()
            );
            return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }


    
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
