package com.hays.homework.service;

import com.hays.homework.entity.Subscription;

public interface SubscriptionService {

    Subscription createSubscription(Subscription subscription);

    Subscription getSubscription(Long id);

}
