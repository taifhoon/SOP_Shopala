package com.example.sellerservice.query.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class SellerRestModel implements Serializable {
    private String _id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;
}
