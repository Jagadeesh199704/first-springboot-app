package com.example.bankingapp.service;

import com.example.bankingapp.dto.InsuranceRequest;
import org.springframework.stereotype.Component;

@Component
public interface TestService {

    String fetchProductDetails(String productName);

    String insuranceDetail(InsuranceRequest insuranceRequest);
}
