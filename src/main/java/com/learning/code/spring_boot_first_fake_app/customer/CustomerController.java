package com.learning.code.spring_boot_first_fake_app.customer;

import com.learning.code.spring_boot_first_fake_app.exeption.ApiRequestException;
import com.learning.code.spring_boot_first_fake_app.exeption.NotFoundException;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Not;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    @GetMapping
    List<Customer> getCustomers() {
        return Collections.singletonList(new Customer(1L, "James Bond", "123passwors", "simo@gmail.com"));
    }
    @GetMapping("/{id}")
    Customer getCustomer(@Valid @PathVariable Long id) {
        return customerService.getCustomers()
                .stream().filter(
                        customer -> customer.getId()
                                .equals(id)).findFirst().orElseThrow(
                                        () ->{
                                            NotFoundException notFoundException = new NotFoundException("customer with id: " + id + " not found ");
                                            LOGGER.error("error at getting customer {}",id ,notFoundException);
                                            return notFoundException;
                                        }                );
    }

    @GetMapping("/{id}/exception")
    Customer getCustomerException(@Valid @PathVariable Long id) {
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }
}
