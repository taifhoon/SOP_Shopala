package com.example.sellerservice.command.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateSellerRestModel implements Serializable {
    private String _id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;
}
