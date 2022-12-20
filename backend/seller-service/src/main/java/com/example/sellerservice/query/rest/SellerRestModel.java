package com.example.sellerservice.query.rest;

import lombok.Data;

@Data
public class SellerRestModel {
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;
}
