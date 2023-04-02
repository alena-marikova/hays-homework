package com.hays.homework.ctrl;

import com.hays.homework.dto.QuotationDTO;
import com.hays.homework.entity.Quotation;
import com.hays.homework.service.QuotationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/quotation")
public class QuotationCtrl {

    private QuotationService quotationService;
    private ModelMapper modelMapper;

    public QuotationCtrl(QuotationService quotationService, ModelMapper modelMapper) {
        this.quotationService = quotationService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createQuotation(@RequestBody QuotationDTO quotationDTO){
        Quotation quotation = modelMapper.map(quotationDTO, Quotation.class);
        quotationService.createQuotation(quotation);
    }

}
