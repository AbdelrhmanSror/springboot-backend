package com.jumia.SQLite.springboot;

import com.jumia.SQLite.springboot.entity.Country;
import com.jumia.SQLite.springboot.entity.CountryCode;
import com.jumia.SQLite.springboot.entity.Customer;
import com.jumia.SQLite.springboot.entity.State;
import com.jumia.SQLite.springboot.repository.CustomerDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceTests {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testReadCustomers() {
        Iterable<Customer> customers = customerDao.findAll();
        assertAndPrint(customers);
    }


    public void assertAndPrint(Iterable<Customer> customers) {
        Assertions.assertThat(customers).hasSizeGreaterThan(0);
        for (Customer customer : customers) {
            System.out.println(customer);
        }

    }

    //first we filter the number based on validity
    //second we filter all number that match the country code number regex
    @Test
    public void getFilteredCustomerUsingPhoneNumber() {
        List<Customer> customersMatchTheState = getCustomersWithValidNotValidState(State.VALID);
        Country country = CountryCode.getCountry("5");
        if (country == null) testReadCustomers();
        else
            assertAndPrint(getCustomersWithSameCountryCode(customersMatchTheState, CountryCode.getCountry("5").getCountryCodeRegex()));

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
            return country != null && isCustomerPhoneNumberValid(country.getPhoneNumberRegex(), customer.getPhoneNumber());
        }).collect(Collectors.toList());

    }

    // 0 consider as not valid
    // any number other than 0 consider as valid
    private List<Customer> getCustomersWithNotValidState() {
        return customerDao.findAll().stream().filter(customer -> {
            Country country = getCountry(customer);
            //in case  country is null due to wrong phone number of customer
            return country == null || isCustomerPhoneNumberNotValid(country.getPhoneNumberRegex(), customer.getPhoneNumber());

        }).collect(Collectors.toList());

    }

    private Country getCountry(Customer customer) {
        String customerCountryCodeNumber = customer.getCountryCodeNumber();
        return CountryCode.getCountry(customerCountryCodeNumber);
    }



    //here we check for all customers that their country code is match the selected countryPhoneRegex
    // (237) match \(237\)\
    private List<Customer> getCustomersWithSameCountryCode(List<Customer> customers, String countryCodeRegex) {
        return customers.stream().filter(customer -> isCustomerMatchingRegex(countryCodeRegex, customer.getCountryCodeNumber())).collect(Collectors.toList());

    }

    private Boolean isCustomerPhoneNumberValid(String phoneNumberRegex, String phoneNumber) {
        return isCustomerMatchingRegex(phoneNumberRegex, phoneNumber);
    }

    private Boolean isCustomerPhoneNumberNotValid(String phoneNumberRegex, String phoneNumber) {
        return !isCustomerMatchingRegex(phoneNumberRegex, phoneNumber);
    }


    private Boolean isCustomerMatchingRegex(String countryCodeRegex, String customerCountryCodeNumber) {
        Pattern pattern = Pattern.compile(countryCodeRegex);
        Matcher matcher = pattern.matcher(customerCountryCodeNumber);
        return matcher.matches();
    }


}
