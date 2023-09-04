package com.ambula.controller.advisor;

import com.ambula.exception.AmbulaCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AmbulaRestControllerAdvisor {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AmbulaCustomException.class)
    public String handleAlSudaisCustomException(AmbulaCustomException ambulaCustomException) {
        return ambulaCustomException.getMessage();
    }
}
