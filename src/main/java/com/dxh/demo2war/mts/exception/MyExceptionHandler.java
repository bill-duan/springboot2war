package com.dxh.demo2war.mts.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger("log1");

    @ExceptionHandler(RuntimeException.class)
    public ExceptionResponseEntity runtimeExceptionHandler(HttpServletRequest request,
                                                           final Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        RuntimeException exception = (RuntimeException) e;
        logger.info("RuntimeException");
        return new ExceptionResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
    }
}
