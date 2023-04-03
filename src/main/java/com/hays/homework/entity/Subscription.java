package com.hays.homework.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;


@Entity(name = "SUBSCRIPTION")
@Data
@NoArgsConstructor
public class Subscription {

    @Id
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "QUOTATION_ID")
    private Quotation quotation;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "VALID_UNTIL")
    @Temporal(TemporalType.DATE)
    private LocalDate validUntil;

}
