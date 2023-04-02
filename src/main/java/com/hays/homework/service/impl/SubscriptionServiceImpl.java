package com.hays.homework.service.impl;

import com.hays.homework.entity.Subscription;
import com.hays.homework.service.exception.SubscriptionNotFoundException;
import com.hays.homework.repository.SubscriptionRepository;
import com.hays.homework.service.SubscriptionService;
import com.hays.homework.service.validator.SubscriptionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    @Transactional
    public void createSubscription(Subscription subscription) {
        SubscriptionValidator.validateSubscription(subscription);
        subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription getSubscription(Long id) {
        Optional<Subscription> byId = subscriptionRepository.findById(id);
        return byId.orElseThrow(SubscriptionNotFoundException::new);
    }
}
