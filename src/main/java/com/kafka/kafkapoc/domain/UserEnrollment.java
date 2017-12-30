package com.kafka.kafkapoc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
public class UserEnrollment {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    private String signedOnHarrassementPolicy;
    private String signedOnEmployeeAgreement;
    private String enrolledForMedicalInsurance;
    private String enrolledForBenefits;

}
