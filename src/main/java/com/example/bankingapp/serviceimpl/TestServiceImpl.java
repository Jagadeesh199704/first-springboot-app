package com.example.bankingapp.serviceimpl;

import com.example.bankingapp.dto.InsuranceRequest;
import com.example.bankingapp.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String fetchProductDetails(String productName) {
        if (productName != null) {
            switch (productName) {
                case "Washing Machine":
                    return "Samsung Washing Machine Model No.WW61, Sl.No. 1254321SA45";
                case "LED TV":
                    return "LG LED TV Model:LG001, Sl.No: 12254, Price: 25000";
                default:
                    return "No Products Found!!!";
            }
        } else {
            return "Product name cannot be null";
        }
    }

    @Override
    public String insuranceDetail(InsuranceRequest insuranceRequest) {

        //DB logic

        return null;
    }

}
