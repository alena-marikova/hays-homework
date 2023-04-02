package com.hays.homework.service.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id){
        super("Customer with id " + id + " does not exists.");
    }
}
