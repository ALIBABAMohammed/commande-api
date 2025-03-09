package com.learning.code.spring_boot_first_fake_app.customer;

import java.util.List;

public interface CustomerRepo {
    List<Customer> getCustomers();
    int save(Customer customer);
}
