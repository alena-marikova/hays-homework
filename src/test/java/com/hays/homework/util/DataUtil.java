package com.hays.homework.util;

import com.hays.homework.dto.CustomerDTO;
import com.hays.homework.dto.QuotationDTO;
import com.hays.homework.dto.SubscriptionDTO;
import com.hays.homework.entity.Customer;
import com.hays.homework.entity.Quotation;
import com.hays.homework.entity.Subscription;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtil {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static ModelMapper modelMapper = new ModelMapper();

    public static Customer createGenericCustomer(){
        Customer customer = new Customer();
        customer.setEmail("test@test.com");
        customer.setFirstName("Name");
        customer.setLastName("Surname");
        customer.setBirthDate(LocalDate.parse("12-12-1970", formatter));
        return customer;
    }

    public static Quotation createGenericQuotation(){
        Quotation quotation = new Quotation();
        quotation.setCustomer(createGenericCustomer());
        quotation.setBeginningOfInsurance(LocalDate.parse("12-12-2023", formatter));
        quotation.setInsuredAmount(4000L);
        quotation.setDateOfSigningMortgage(LocalDate.parse("11-12-2023", formatter));
        return quotation;
    }

    public static Subscription createGenericSubscription(){
        Subscription subscription = new Subscription();
        subscription.setQuotation(createGenericQuotation());
        subscription.setStartDate(LocalDate.parse("12-12-2023", formatter));
        subscription.setValidUntil(LocalDate.parse("12-12-2050", formatter));
        return subscription;
    }

    public static CustomerDTO createGenericCustomerDTO(){
        return modelMapper.map(createGenericCustomer(), CustomerDTO.class);
    }

    public static QuotationDTO createGenericQuotationDTO(){
        return modelMapper.map(createGenericQuotation(), QuotationDTO.class);
    }
    public static SubscriptionDTO createGenericSubscriptionDTO(){
        return modelMapper.map(createGenericSubscription(), SubscriptionDTO.class);
    }
}
