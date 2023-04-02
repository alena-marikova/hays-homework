package com.hays.homework.ctrl;

import com.hays.homework.dto.CustomerDTO;
import com.hays.homework.entity.Customer;
import com.hays.homework.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/customer")
public class CustomerCtrl {

    private final CustomerService customerService;

    private final ModelMapper modelMapper;

    public CustomerCtrl(CustomerService customerService, ModelMapper modelMapper){
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler()
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerService.updateCustomer(customer);
    }

    @GetMapping
    public CustomerDTO getCustomer(@RequestParam("id") Long id){
        Customer customer = customerService.getCustomer(id);
        return modelMapper.map(customer, CustomerDTO.class);
    }


}
