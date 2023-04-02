package com.hays.homework.service.validator;

import com.hays.homework.entity.Customer;
import com.hays.homework.service.validator.exception.CustomerNotValidException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerValidator {

    static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    public static void validateCustomer(Customer customer){
        String email = customer.getEmail();
        Matcher matcher = Pattern.compile(emailRegex).matcher(email);
        if (!matcher.matches()){
            throw new CustomerNotValidException("Email address " + email + " for customer is not correct");
        }
        // There needs to be similar validation for phone number, but it depends on requirements and localization of app since phone numbers differs from country to country
    }
}
