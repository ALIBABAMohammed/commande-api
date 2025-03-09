package com.learning.code.spring_boot_first_fake_app.ws.converter;

import com.learning.code.spring_boot_first_fake_app.bean.Customer;
import com.learning.code.spring_boot_first_fake_app.ws.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter extends AbstractConverter<Customer, CustomerDto> {


    @Override
    public CustomerDto toDto(Customer item) {

        CustomerDto customerDto = null;
        if( item != null) {
            customerDto = new CustomerDto();
            customerDto.setId(item.getId());
            customerDto.setName(item.getName());
            customerDto.setEmail(item.getEmail());
        }
        return customerDto;
    }

    @Override
    public Customer toItem(CustomerDto customerDto) {

        Customer customerItem = null;
        if( customerDto != null) {
            customerItem = new Customer();
            customerItem.setEmail(customerDto.getEmail());
            customerItem.setId(customerDto.getId());
            customerItem.setName(customerDto.getName());
            customerItem.setPassword(customerDto.getPassword());
        }
        return customerItem;
    }
}
