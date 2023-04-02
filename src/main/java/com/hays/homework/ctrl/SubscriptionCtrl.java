package com.hays.homework.ctrl;

import com.hays.homework.dto.SubscriptionDTO;
import com.hays.homework.entity.Subscription;
import com.hays.homework.service.SubscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/subscription")
public class SubscriptionCtrl {

    private SubscriptionService subscriptionService;
    private ModelMapper modelMapper;

    public SubscriptionCtrl(SubscriptionService subscriptionService, ModelMapper modelMapper) {
        this.subscriptionService = subscriptionService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSubscription(@RequestBody SubscriptionDTO subscriptionDTO){
        Subscription subscription = modelMapper.map(subscriptionDTO, Subscription.class);
        subscriptionService.createSubscription(subscription);
    }

    @GetMapping
    public SubscriptionDTO getSubscription(@RequestParam("id") Long id){
        Subscription subscription = subscriptionService.getSubscription(id);
        return modelMapper.map(subscription, SubscriptionDTO.class);
    }

}
