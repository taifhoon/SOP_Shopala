package com.example.sellerservice.command.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateSellerRestModel implements Serializable {
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;
}
