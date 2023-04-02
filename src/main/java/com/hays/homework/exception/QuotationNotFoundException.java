package com.hays.homework.exception;

public class QuotationNotFoundException extends RuntimeException{

    public QuotationNotFoundException() {
        super("Quotation was not found");
    }

}
