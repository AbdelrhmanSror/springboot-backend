package com.jumia.SQLite.springboot.service;

import com.jumia.SQLite.springboot.entity.Country;
import com.jumia.SQLite.springboot.entity.CountryCode;
import com.jumia.SQLite.springboot.entity.Customer;
import com.jumia.SQLite.springboot.entity.State;
import com.jumia.SQLite.springboot.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;


    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    //first we filter the number based on validity
    //second we filter all number that match the country code number regex
    public List<Customer> getFilteredCustomers(String countryCode, int state) {
        List<Customer> customersMatchTheState = getCustomersWithValidNotValidState(state);
        Country country = CountryCode.getCountry(countryCode);
        //for case if user enter invalid code number we just return the customers that match the state.
        if (isNotValidCountry(country)) return customersMatchTheState;
        return getCustomersWithSameCountryCode(customersMatchTheState, country.getCountryCodeRegex());

    }

    private boolean isNotValidCountry(Country country) {
        return country == null;
    }

    private boolean isValidCountry(Country country) {
        return country != null;
    }

    // 0 consider as not valid
    // any number other than 0 consider as valid
    private List<Customer> getCustomersWithValidNotValidState(int state) {
        if (state == State.NOT_VALID) {
            return getCustomersWithNotValidState();
        } else {
            return getCustomersWithValidState();
        }


    }


    // 0 consider as not valid
    // any number other than 0 consider as valid
    private List<Customer> getCustomersWithValidState() {
        return customerDao.findAll().stream().filter(customer -> {
            Country country = getCountry(customer);
            return isValidCountry(country) && isCustomerPhoneNumberValid(country.getPhoneNumberRegex(), customer.getPhoneNumber());
        }).collect(Collectors.toList());

    }

    // 0 consider as not valid
    // any number other than 0 consider as valid
    private List<Customer> getCustomersWithNotValidState() {
        return customerDao.findAll().stream().filter(customer -> {
            Country country = getCountry(customer);
            //in case  country is null due to wrong phone number of customer
            return isNotValidCountry(country) || isCustomerPhoneNumberNotValid(country.getPhoneNumberRegex(), customer.getPhoneNumber());

        }).collect(Collectors.toList());

    }

    private Country getCountry(Customer customer) {
        String customerCountryCodeNumber = customer.getCountryCodeNumber();
        return CountryCode.getCountry(customerCountryCodeNumber);
    }


    //here we check for all customers that their country code is match the selected countryPhoneRegex
    // (237) match \(237\)\
    private List<Customer> getCustomersWithSameCountryCode(List<Customer> customers, String countryCodeRegex) {
        return customers.stream().filter(customer -> isMatchingRegex(countryCodeRegex, customer.getCountryCodeNumber())).collect(Collectors.toList());

    }

    private Boolean isCustomerPhoneNumberValid(String phoneNumberRegex, String phoneNumber) {
        return isMatchingRegex(phoneNumberRegex, phoneNumber);
    }

    private Boolean isCustomerPhoneNumberNotValid(String phoneNumberRegex, String phoneNumber) {
        return !isMatchingRegex(phoneNumberRegex, phoneNumber);
    }


    private Boolean isMatchingRegex(String regex, String valueToValidate) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valueToValidate);
        return matcher.matches();
    }


}
