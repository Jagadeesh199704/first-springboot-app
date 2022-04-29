package com.example.bankingapp.serviceimpl;

import com.example.bankingapp.dto.InsuranceRequest;
import com.example.bankingapp.dto.UserDetails;
import com.example.bankingapp.entity.User;
import com.example.bankingapp.repository.UserDAO;
import com.example.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserDAO userDAO;

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

        User user = new User();
        user.setName(insuranceRequest.getName());
        user.setAge(insuranceRequest.getAge());

        userDAO.save(user);
        return "Saved Sucessfully!!!";
    }

    @Override
    public UserDetails getUserDetails(int userId) {
        //DB call
        Optional<User> user = userDAO.findById(userId);

        if(!user.isPresent()){
            throw new NullPointerException("User not found");
        }
        User userDetailsFromDb = user.get();

        UserDetails userDetails = new UserDetails();
        userDetails.setName(userDetailsFromDb.getName());
        userDetails.setAge(userDetailsFromDb.getAge());
        userDetails.setId(userDetailsFromDb.getId());

        return userDetails;
    }

}
