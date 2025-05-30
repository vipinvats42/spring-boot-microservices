package com.eazybytes.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotfoundexception extends RuntimeException{
   
    public ResourceNotfoundexception(String resourceName,String filedName,String fieldValue) {
        super(String.format("%s not found with the given input data %s:%s",resourceName,filedName,fieldValue));
    }
    
}
