package com.hays.homework.service;

import com.hays.homework.entity.Subscription;
import com.hays.homework.repository.SubscriptionRepository;
import com.hays.homework.service.impl.SubscriptionServiceImpl;
import com.hays.homework.service.validator.exception.QuotationNotValidException;
import com.hays.homework.util.DataUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubscriptionServiceImplTest {
    private final SubscriptionRepository subscriptionRepository = mock(SubscriptionRepository.class);

    private final SubscriptionService subscriptionService = new SubscriptionServiceImpl(subscriptionRepository);


    @Test
    public void createSubscriptionTest(){
        Subscription subscription = DataUtil.createGenericSubscription();
        when(subscriptionRepository.save(any())).thenReturn(subscription);
        subscriptionService.createSubscription(subscription);
    }

    @Test
    public void createSubscriptionTestNotValid(){
        Subscription subscription = DataUtil.createGenericSubscription();
        subscription.getQuotation().setInsuredAmount(0L);
        when(subscriptionRepository.save(any())).thenReturn(subscription);
        assertThrows(QuotationNotValidException.class, () -> subscriptionService.createSubscription(subscription));

    }
}
