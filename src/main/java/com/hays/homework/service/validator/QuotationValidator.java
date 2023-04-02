package com.hays.homework.service.validator;

import com.hays.homework.entity.Quotation;
import com.hays.homework.service.validator.exception.QuotationNotValidException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuotationValidator {

    public static void validateQuotation(Quotation quotation){
        Long insuredAmount = quotation.getInsuredAmount();
        if (insuredAmount < 0){
            throw new QuotationNotValidException("Insured amount has to be bigger then 0");
        }
        CustomerValidator.validateCustomer(quotation.getCustomer());
    }

}
