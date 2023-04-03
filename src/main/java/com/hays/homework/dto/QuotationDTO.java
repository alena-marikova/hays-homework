package com.hays.homework.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
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
}
