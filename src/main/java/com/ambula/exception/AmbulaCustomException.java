package com.ambula.exception;

public class AmbulaCustomException extends RuntimeException{

    private String message;

    public AmbulaCustomException(){

    }

    public AmbulaCustomException(String message){
        super(message);
    }

}
