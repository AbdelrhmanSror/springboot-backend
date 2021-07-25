package com.jumia.SQLite.springboot.viewmodel;

import com.jumia.SQLite.springboot.models.Customer;
import com.jumia.SQLite.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * class responsible for controlling the server he is acting as mediator between server and client
 */
@RestController
@CrossOrigin(origins = "*")
public class CustomerViewModel {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "The application is up...";
    }


    @RequestMapping(value = "Customers", method = RequestMethod.GET)
    public List<Customer> readCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value = "FilteredCustomers", method = RequestMethod.GET)
    public List<Customer> readFilteredCustomers(@RequestParam("countryCode") String countryCode, @RequestParam("state") int state) {
        return customerService.getFilteredCustomers(countryCode, state);
    }


}
