package com.hays.homework.ctrl;

import com.hays.homework.dto.CustomerDTO;
import com.hays.homework.entity.Customer;
import com.hays.homework.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerCtrl {

    private final CustomerService customerService;

    private final ModelMapper modelMapper;

    public CustomerCtrl(CustomerService customerService, ModelMapper modelMapper){
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return modelMapper.map(updatedCustomer, CustomerDTO.class);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerDTO getCustomer(@RequestParam("id") Long id){
        Customer customer = customerService.getCustomer(id);
        return modelMapper.map(customer, CustomerDTO.class);
    }


}
