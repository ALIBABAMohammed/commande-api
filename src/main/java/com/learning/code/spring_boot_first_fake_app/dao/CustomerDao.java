package com.learning.code.spring_boot_first_fake_app.dao;


import com.learning.code.spring_boot_first_fake_app.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    Customer findByRef(String ref);
    int deleteByRef(String ref);
    Customer findByEmail(String email);

    List<Customer> findAll();

     Object save(Customer customer);
}
