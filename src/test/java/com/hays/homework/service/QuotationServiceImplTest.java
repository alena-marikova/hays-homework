package com.hays.homework.service;

import com.hays.homework.entity.Quotation;
import com.hays.homework.repository.QuotationRepository;
import com.hays.homework.service.impl.QuotationServiceImpl;
import com.hays.homework.service.validator.exception.QuotationNotValidException;
import com.hays.homework.util.DataUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuotationServiceImplTest {

    private final QuotationRepository quotationRepository = mock(QuotationRepository.class);

    private final QuotationService quotationService = new QuotationServiceImpl(quotationRepository);


    @Test
    public void createQuotationTest(){
        Quotation quotation = DataUtil.createGenericQuotation();
        when(quotationRepository.save(any())).thenReturn(quotation);
        quotationService.createQuotation(quotation);
    }

    @Test
    public void createQuotationTestNotValid(){
        Quotation quotation = DataUtil.createGenericQuotation();
        quotation.setInsuredAmount(0L);
        when(quotationRepository.save(any())).thenReturn(quotation);
        assertThrows(QuotationNotValidException.class, () -> quotationService.createQuotation(quotation));
    }

}
