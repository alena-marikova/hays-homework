package com.hays.homework.service.exception;

public class SubscriptionNotFoundException extends RuntimeException{

    public SubscriptionNotFoundException() {
        super("Subscription was not found");
    }
}
