package com.hays.homework.service.exception;

public class QuotationNotFoundException extends RuntimeException{

    public QuotationNotFoundException() {
        super("Quotation was not found");
    }

}
