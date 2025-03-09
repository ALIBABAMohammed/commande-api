package com.learning.code.spring_boot_first_fake_app.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class CustomerRepository implements CustomerRepo{

    @Override
    public List<Customer> getCustomers() {
        return Collections.emptyList();
    }

    @Override
    public int save(Customer customer) {
        return 1;
    }
}
