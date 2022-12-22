package com.example.customerservice.command.model;

import lombok.Data;

@Data
public class CustomerLoginRestModel {
    private String email;
    private String password;
}
