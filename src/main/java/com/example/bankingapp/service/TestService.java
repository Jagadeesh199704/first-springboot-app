package com.example.bankingapp.service;

import com.example.bankingapp.dto.InsuranceRequest;
import com.example.bankingapp.dto.UserDetails;
import org.springframework.stereotype.Component;

@Component
public interface TestService {

    String fetchProductDetails(String productName);

    String insuranceDetail(InsuranceRequest insuranceRequest);

    UserDetails getUserDetails(int userId);

    UserDetails fetchUserDetailsByName(String userName);

    UserDetails fetchUserDetailsByNameNdId(int id, String name);
}
