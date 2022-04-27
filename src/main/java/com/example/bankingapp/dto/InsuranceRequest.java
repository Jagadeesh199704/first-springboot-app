package com.example.bankingapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class InsuranceRequest {

    private String name;
    private String moblileNumber;
    private String location;
    private String insuranceAmount;
    private String insuranceType;
}
