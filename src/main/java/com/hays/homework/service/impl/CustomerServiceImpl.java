package com.hays.homework.service.impl;

import com.hays.homework.entity.Customer;
import com.hays.homework.exception.CustomerNotFoundException;
import com.hays.homework.repository.CustomerRepository;
import com.hays.homework.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer){
        if (customer.getId() == null || customerRepository.getReferenceById(customer.getId()) == null){
            throw new CustomerNotFoundException(customer.getId());
        }
        Customer savedCustomer = customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElseThrow(() -> new CustomerNotFoundException(id));
    }
}
