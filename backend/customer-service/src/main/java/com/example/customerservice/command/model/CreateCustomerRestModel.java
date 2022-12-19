package com.example.customerservice.command.model;

import lombok.Data;

@Data
public class CreateCustomerRestModel {
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
}
