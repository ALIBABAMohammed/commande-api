package com.learning.code.spring_boot_first_fake_app.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private boolean useFakeCustomerRepo;
    @Bean
    CommandLineRunner commandLineRunner () {
        return args -> {
            System.out.println("Command line runner hooray");
        };

    }
    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeCustomerRepo" + useFakeCustomerRepo);
        return useFakeCustomerRepo ?
                new CustomerFakeRepository() :
                new CustomerRepository();
    }
}
