package com.learning.code.spring_boot_first_fake_app.ws.facade;

import com.learning.code.spring_boot_first_fake_app.bean.Customer;
import com.learning.code.spring_boot_first_fake_app.service.facade.CustomerService;
import com.learning.code.spring_boot_first_fake_app.ws.converter.CustomerConverter;
import com.learning.code.spring_boot_first_fake_app.ws.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Gestion-Commercial/customers")
public class CustomerProvided {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerConverter customerConverter;

    @PostMapping("/")
    public int save(@RequestBody CustomerDto customerDto){

        Customer customer = customerConverter.toItem(customerDto);
        return customerService.save(customer);
    }

    @GetMapping("/{email}")
    public CustomerDto findByEmail(@PathVariable String email) {
        Customer customerFound = customerService.findByEmail(email);
        return customerConverter.toDto(customerFound);
    }

    @DeleteMapping("/customer/{ref}")
    public int deleteByRef(@PathVariable String ref){
      return  customerService.deleteByRef(ref);
    }
}
