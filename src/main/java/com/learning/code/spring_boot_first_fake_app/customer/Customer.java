package com.learning.code.spring_boot_first_fake_app.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    private final Long id;
    @NotBlank(message = "name must not be empty")
    private final String name;

    @NotBlank(message = "password must not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private final String password;

    public String getEmail() {
        return email;
    }
    @NotBlank(message = "email must not be empty")
    @Email
    private final String email;

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
