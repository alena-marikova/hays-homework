package com.hays.homework.repository;

import com.hays.homework.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
