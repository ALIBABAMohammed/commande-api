package com.learning.code.spring_boot_first_fake_app.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value="Fake")
public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond", "1234password","simo@gmail.com"),
                new Customer(1L, "James Bond", "password123", "simo1@gmail.com")
        );
    }

    @Override
    public int save(Customer customer) {
        return 0;
    }
}
