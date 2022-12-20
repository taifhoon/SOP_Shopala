package com.example.sellerservice.core.event;

import lombok.Data;

@Data
public class SellerCreatedEvent {
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;
}
