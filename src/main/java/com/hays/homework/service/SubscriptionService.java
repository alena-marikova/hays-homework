package com.hays.homework.service;

import com.hays.homework.entity.Subscription;

public interface SubscriptionService {

    void createSubscription(Subscription subscription);

    Subscription getSubscription(Long id);

}
