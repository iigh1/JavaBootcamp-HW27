package com.example.springsecurityhw27.ApiException;

public class ApiException extends RuntimeException{

    public ApiException (String message){
        super(message);
    }
}
