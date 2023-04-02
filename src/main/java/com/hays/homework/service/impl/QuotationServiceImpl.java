package com.hays.homework.service.impl;

import com.hays.homework.entity.Quotation;
import com.hays.homework.repository.QuotationRepository;
import com.hays.homework.service.QuotationService;
import com.hays.homework.service.validator.QuotationValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QuotationServiceImpl implements QuotationService {

    private final QuotationRepository quotationRepository;

    public QuotationServiceImpl(QuotationRepository quotationRepository){
        this.quotationRepository = quotationRepository;
    }

    @Override
    @Transactional
    public void createQuotation(Quotation quotation) {
        QuotationValidator.validateQuotation(quotation);
        quotationRepository.save(quotation);
    }
}
