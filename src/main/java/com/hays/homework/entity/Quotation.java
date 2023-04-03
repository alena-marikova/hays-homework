package com.hays.homework.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;

@Entity(name = "QUOTATION")
@Data
@NoArgsConstructor
public class Quotation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(name = "INSURANCE_BEGINNING", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate beginningOfInsurance;

    @Column(name = "INSURED_AMOUNT")
    private Long insuredAmount;

    @Column(name = "MORTGAGE_SIGNING_DATE")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfSigningMortgage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

}
