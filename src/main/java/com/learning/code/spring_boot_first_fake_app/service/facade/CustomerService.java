package com.learning.code.spring_boot_first_fake_app.service.facade;


import com.learning.code.spring_boot_first_fake_app.bean.Customer;

import java.util.List;

public interface CustomerService {

    Customer findByEmail(String email);
    Customer findByRef(String ref);
    List<Customer> getAll();
    int deleteByRef(String ref);
    int save(Customer customer);
}
