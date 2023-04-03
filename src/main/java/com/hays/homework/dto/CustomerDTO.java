package com.hays.homework.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerDTO implements Serializable {

    static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    @NonNull
    private String lastName;

    private String middleName;

    @NonNull
    private String email;

    private String phoneNumber;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

}
