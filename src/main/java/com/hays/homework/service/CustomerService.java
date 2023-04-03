package com.hays.homework.service;

import com.hays.homework.entity.Customer;

public interface CustomerService {

    Customer updateCustomer(Customer customer);

    Customer getCustomer(Long id);

}
