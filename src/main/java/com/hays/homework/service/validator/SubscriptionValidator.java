package com.hays.homework.service.validator;

import com.hays.homework.entity.Subscription;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubscriptionValidator {

    public static void validateSubscription(Subscription subscription){
        QuotationValidator.validateQuotation(subscription.getQuotation());
    }

}
