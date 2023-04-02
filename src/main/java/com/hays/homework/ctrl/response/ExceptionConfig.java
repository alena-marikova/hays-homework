package com.hays.homework.ctrl.response;

import com.hays.homework.service.exception.CustomerNotFoundException;
import com.hays.homework.service.exception.QuotationNotFoundException;
import com.hays.homework.service.exception.SubscriptionNotFoundException;
import com.hays.homework.service.validator.exception.CustomerNotValidException;
import com.hays.homework.service.validator.exception.QuotationNotValidException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CustomerNotFoundException.class, QuotationNotFoundException.class, SubscriptionNotFoundException.class})
    public final ResponseEntity<Object> handleNotFoundException(RuntimeException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({CustomerNotValidException.class, QuotationNotValidException.class})
    public final ResponseEntity<Object> handleNotValidException(RuntimeException e, WebRequest request){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}