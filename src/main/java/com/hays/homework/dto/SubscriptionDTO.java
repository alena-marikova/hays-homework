package com.hays.homework.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SubscriptionDTO implements Serializable {

    static final long serialVersionUID = 1L;

    private Long id;

    private QuotationDTO quotation;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate startDate;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate validUntil;
}
