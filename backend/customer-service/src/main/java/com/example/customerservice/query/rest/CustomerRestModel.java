package com.example.customerservice.query.rest;

import lombok.Data;

@Data
public class CustomerRestModel {
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
}
