package com.hays.homework.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class SubscriptionDTO implements Serializable {

    private Long id;

    private QuotationDTO quotation;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate validUntil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuotationDTO getQuotation() {
        return quotation;
    }

    public void setQuotation(QuotationDTO quotation) {
        this.quotation = quotation;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }
}
