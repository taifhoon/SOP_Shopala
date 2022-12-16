package com.example.customerservice;

import lombok.Data;

@Data
public class CreateCustomerRestModel {

    private String username;
    private String password;
    private String role;
}
