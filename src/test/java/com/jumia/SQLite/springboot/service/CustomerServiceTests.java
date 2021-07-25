package com.jumia.SQLite.springboot.service;

import com.jumia.SQLite.springboot.models.Customer;
import com.jumia.SQLite.springboot.models.State;
import com.jumia.SQLite.springboot.repository.CustomerDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static com.jumia.SQLite.springboot.service.CustomerServiceUtility.getCustomersWithSameCountryCode;
import static com.jumia.SQLite.springboot.service.CustomerServiceUtility.getCustomersWithValidNotValidState;

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
        List<Customer> customersMatchTheState = getCustomersWithValidNotValidState(customerDao.findAll(), State.NOT_VALID);
        assertAndPrint(getCustomersWithSameCountryCode(customersMatchTheState, "237"));

    }


}
