package com.learning.code.spring_boot_first_fake_app.service.impl;

import com.learning.code.spring_boot_first_fake_app.bean.Customer;
import com.learning.code.spring_boot_first_fake_app.dao.CustomerDao;
import com.learning.code.spring_boot_first_fake_app.service.facade.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public Customer findByEmail(String email) {
        return customerDao.findByEmail(email);
    }

    @Override
    public Customer findByRef(String ref) {
        return customerDao.findByRef(ref);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    @Override
    public int deleteByRef(String ref) {
        return customerDao.deleteByRef(ref);
    }

    @Override
    public int save(Customer customer) {
        if(findByEmail(customer.getEmail()) != null){
            return -1;
        }else{
            customerDao.save(customer);
        return 0;
        }
    }
}
