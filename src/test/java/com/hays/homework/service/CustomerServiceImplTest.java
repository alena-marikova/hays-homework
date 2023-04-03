package com.hays.homework.service;

import com.hays.homework.entity.Customer;
import com.hays.homework.repository.CustomerRepository;
import com.hays.homework.service.exception.CustomerNotFoundException;
import com.hays.homework.service.impl.CustomerServiceImpl;
import com.hays.homework.service.validator.exception.CustomerNotValidException;
import com.hays.homework.util.DataUtil;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    private final CustomerRepository customerRepository = mock(CustomerRepository.class);

    private final CustomerService customerService = new CustomerServiceImpl(customerRepository);


    @Test
    public void updateCustomerTest(){
        Customer customer = DataUtil.createGenericCustomer();
        customer.setId(1L);
        when(customerRepository.getReferenceById(1L)).thenReturn(customer);
        customer.setMiddleName("MiddleName");
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        assertEquals(updatedCustomer, customer);
    }

    @Test
    public void updateCustomerTestCustomerNotValid(){
        Customer customer = DataUtil.createGenericCustomer();
        customer.setId(1L);
        when(customerRepository.getReferenceById(1L)).thenReturn(customer);
        customer.setEmail("bla");

        assertThrows(CustomerNotValidException.class, () -> customerService.updateCustomer(customer));
    }

    @Test
    public void updateCustomerTestCustomerNotFound(){
        Customer customer = DataUtil.createGenericCustomer();
        customer.setId(1L);
        when(customerRepository.getReferenceById(1L)).thenReturn(null);

        assertThrows(CustomerNotFoundException.class, () -> customerService.updateCustomer(customer));
    }

}
