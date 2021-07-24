package com.jumia.SQLite.springboot.service;

import com.jumia.SQLite.springboot.entity.Customer;
import com.jumia.SQLite.springboot.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jumia.SQLite.springboot.service.CustomerServiceUtility.getCustomersWithSameCountryCode;
import static com.jumia.SQLite.springboot.service.CustomerServiceUtility.getCustomersWithValidNotValidState;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;


    //getting all customers with valid and not valid state
    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    //first we filter the number based on validity
    //second we filter all number that match the country code number regex
    public List<Customer> getFilteredCustomers(String countryCode, int state) {
        List<Customer> customersMatchTheState = getCustomersWithValidNotValidState(customerDao.findAll(), state);
        return getCustomersWithSameCountryCode(customersMatchTheState, countryCode);

    }


}
