package com.jumia.SQLite.springboot.service;

import com.jumia.SQLite.springboot.entity.Country;
import com.jumia.SQLite.springboot.entity.CountryCode;
import com.jumia.SQLite.springboot.entity.Customer;
import com.jumia.SQLite.springboot.entity.State;

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


    //here we check for all customers that their country code is match the selected countryPhoneRegex
    // (237) match \(237\)\
    public static List<Customer> getCustomersWithSameCountryCode(List<Customer> customers, String countryCodeRegex) {
        return customers.stream().filter(customer -> isMatchingRegex(countryCodeRegex, CountryCode.getCountryCodeNumber(customer.getPhoneNumber()))).collect(Collectors.toList());

    }

    // 0 consider as not valid
    // any number other than 0 consider as valid
    private static List<Customer> getCustomersWithValidState(List<Customer> customers) {
        return customers.stream().filter(customer -> {
            Country country = getCountry(customer);
            return isValidCountry(country) && isCustomerPhoneNumberValid(country.getPhoneNumberRegex(), customer.getPhoneNumber());
        }).collect(Collectors.toList());

    }

    // 0 consider as not valid
    // any number other than 0 consider as valid
    private static List<Customer> getCustomersWithNotValidState(List<Customer> customers) {
        return customers.stream().filter(customer -> {
            Country country = getCountry(customer);
            //in case  country is null due to wrong phone number of customer
            return isNotValidCountry(country) || isCustomerPhoneNumberNotValid(country.getPhoneNumberRegex(), customer.getPhoneNumber());

        }).collect(Collectors.toList());

    }

    public static boolean isNotValidCountry(Country country) {
        return country == null;
    }

    private static boolean isValidCountry(Country country) {
        return country != null;
    }


    private static Country getCountry(Customer customer) {
        String customerCountryCodeNumber = CountryCode.getCountryCodeNumber(customer.getPhoneNumber());
        return CountryCode.getCountry(customerCountryCodeNumber);
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
