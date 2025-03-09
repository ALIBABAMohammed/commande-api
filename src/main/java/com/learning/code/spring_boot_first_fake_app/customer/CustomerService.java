package com.learning.code.spring_boot_first_fake_app.customer;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepo customerRepo;

   // public CustomerService(@Qualifier("Fake") CustomerRepo customerRepo) {
      //  this.customerRepo = customerRepo;
    //}
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers() {
        LOGGER.info("List of customers");
        return customerRepo.getCustomers() ;
    }
}
