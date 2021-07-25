package com.jumia.SQLite.springboot.service;

import com.jumia.SQLite.springboot.models.CountryCode;
import com.jumia.SQLite.springboot.models.Customer;
import com.jumia.SQLite.springboot.models.State;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomerServiceUtility {

    // 0 consider as not valid
    // any number other than 0 consider as valid
    public static List<Customer> getCustomersWithValidNotValidState(List<Customer> customers, int state) {
        if (state == State.NOT_VALID) {
            return getCustomersWithNotValidState(customers);
        } else {
            return getCustomersWithValidState(customers);
        }


    }

    
    public static List<Customer> getCustomersWithSameCountryCode(List<Customer> customers, String countryCode) {
        //for case if user enter invalid code number we just return All  customers that match the state.
        if (CountryCode.isNotExist(countryCode)) return customers;
        return customers.stream().filter(customer -> isMatchingRegex(getCountryCodeNumberRegex(countryCode), customer.getCountryCodeNumber())).collect(Collectors.toList());

    }

    private static String getCountryCodeNumberRegex(String countryCodeNumber) {
        return CountryCode.getCountry(countryCodeNumber).getCodeRegex();
    }


    // 0 consider as not valid
    // any number other than 0 consider as valid
    private static List<Customer> getCustomersWithValidState(List<Customer> customers) {
        return customers.stream().filter(CustomerServiceUtility::isCustomerValid).collect(Collectors.toList());

    }

    // 0 consider as not valid
    // any number other than 0 consider as valid
    private static List<Customer> getCustomersWithNotValidState(List<Customer> customers) {
        //in case  country is null due to wrong phone number of customer
        return customers.stream().filter(CustomerServiceUtility::isCustomerNotValid).collect(Collectors.toList());

    }

    private static boolean isCustomerValid(Customer customer) {
        return CountryCode.isExist(customer.getCountryCodeNumber()) && isCustomerPhoneNumberValid(CountryCode.getCountry(customer.getCountryCodeNumber()).getPhoneRegex(), customer.getPhoneNumber());
    }


    private static boolean isCustomerNotValid(Customer customer) {
        return CountryCode.isNotExist(customer.getCountryCodeNumber()) || isCustomerPhoneNumberNotValid(CountryCode.getCountry(customer.getCountryCodeNumber()).getPhoneRegex(), customer.getPhoneNumber());
    }


    private static Boolean isCustomerPhoneNumberValid(String phoneNumberRegex, String phoneNumber) {
        return isMatchingRegex(phoneNumberRegex, phoneNumber);
    }

    private static Boolean isCustomerPhoneNumberNotValid(String phoneNumberRegex, String phoneNumber) {
        return !isMatchingRegex(phoneNumberRegex, phoneNumber);
    }


    private static Boolean isMatchingRegex(String regex, String valueToValidate) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valueToValidate);
        return matcher.matches();
    }


}
