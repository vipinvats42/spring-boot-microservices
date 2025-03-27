package com.eazybytes.accounts.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eazybytes.accounts.dto.ErrorResponseDTO;


/**
 * @Author: vipin tyagi
 * ControllerAdvice : where there is any exception in the application (globally in any any controller) it will be handled here
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class) 
    public ResponseEntity<ErrorResponseDTO> handleGlobalEception(Exception exception,
    WebRequest webRequest){ 
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            webRequest.getDescription(false),
            HttpStatus.INTERNAL_SERVER_ERROR,
            exception.getMessage(),
            LocalDateTime.now()
            );
            return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
  

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
         super.handleMethodArgumentNotValid(ex, headers, status, request);

         Map<String,String> validationError= new HashMap<>();
         List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

         validationErrorList.forEach(error->{
             String fieldName = ((FieldError)error).getField();
             String errorMessage = error.getDefaultMessage();
             validationError.put(fieldName,errorMessage);
         });
         return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);

    }

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
