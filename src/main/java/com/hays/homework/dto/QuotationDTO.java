package com.hays.homework.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

public class QuotationDTO {

    static final long serialVersionUID = 1L;

    private Long id;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate beginningOfInsurance;

    @NonNull
    private Long insuredAmount;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateOfSigningMortgage;

    @NonNull
    private CustomerDTO customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBeginningOfInsurance() {
        return beginningOfInsurance;
    }

    public void setBeginningOfInsurance(LocalDate beginningOfInsurance) {
        this.beginningOfInsurance = beginningOfInsurance;
    }

    @NonNull
    public Long getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(@NonNull Long insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public LocalDate getDateOfSigningMortgage() {
        return dateOfSigningMortgage;
    }

    public void setDateOfSigningMortgage(LocalDate dateOfSigningMortgage) {
        this.dateOfSigningMortgage = dateOfSigningMortgage;
    }

    @NonNull
    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(@NonNull CustomerDTO customer) {
        this.customer = customer;
    }
}
