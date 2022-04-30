package com.example.bankingapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDetails {

    private int id;
    private String name;
    private int age;

    //DTO inside DTO
    private List<UserAddress> address;
}
