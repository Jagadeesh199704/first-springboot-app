package com.example.bankingapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserAddress {

    private String houseNum;
    private String addressLine;
    private String country;
    private int pinCode;
}
