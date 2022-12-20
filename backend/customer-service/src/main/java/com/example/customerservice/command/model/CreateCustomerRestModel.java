package com.example.customerservice.command.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateCustomerRestModel implements Serializable {
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
}
