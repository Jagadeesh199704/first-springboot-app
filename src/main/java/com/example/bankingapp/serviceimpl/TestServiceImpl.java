package com.example.bankingapp.serviceimpl;

import com.example.bankingapp.dto.InsuranceRequest;
import com.example.bankingapp.dto.UserAddress;
import com.example.bankingapp.dto.UserDetails;
import com.example.bankingapp.entity.User;
import com.example.bankingapp.repository.UserDAO;
import com.example.bankingapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        UserDetails userDetails = new UserDetails();
        List<UserAddress> userAddressList = new ArrayList<>();

        if (!user.isPresent()) {
            throw new NullPointerException("User not found");
        }
        User userDetailsFromDb = user.get();

        userDetails.setName(userDetailsFromDb.getName());
        userDetails.setAge(userDetailsFromDb.getAge());
        userDetails.setId(userDetailsFromDb.getId());

        //from address DTO
        UserAddress userAddress = new UserAddress();
        userAddress.setHouseNum("182");
        userAddress.setAddressLine("JP nagar");
        userAddress.setCountry("India");
        userAddress.setPinCode(580001);

        UserAddress userAddress1 = new UserAddress();
        userAddress1.setHouseNum("185");
        userAddress1.setAddressLine("Bapuji nagar");
        userAddress1.setCountry("Davangeri");
        userAddress1.setPinCode(577001);

        userAddressList.add(userAddress);
        userAddressList.add(userAddress1);
        userDetails.setAddress(userAddressList);


        return userDetails;
    }

    @Override
    public UserDetails fetchUserDetailsByName(String userName) {

        User user = userDAO.findByName(userName);
        UserDetails userDetails = new UserDetails();

        userDetails.setName(user.getName());
        userDetails.setAge(user.getAge());
        userDetails.setId(user.getId());
;        return userDetails;
    }

    @Override
    public UserDetails fetchUserDetailsByNameNdId(int id, String name) {
        User user = userDAO.findByIdAndName(id, name);
        UserDetails userDetails = new UserDetails();

        userDetails.setName(user.getName());
        userDetails.setAge(user.getAge());
        userDetails.setId(user.getId());
        return userDetails;

    }

}
