package com.hays.homework.exception;

public class SubscriptionNotFoundException extends RuntimeException{

    public SubscriptionNotFoundException() {
        super("Subscription was not found");
    }
}
