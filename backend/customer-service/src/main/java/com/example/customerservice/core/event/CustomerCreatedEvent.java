package com.example.customerservice.core.event;

import lombok.Data;

import java.util.List;

@Data
public class CustomerCreatedEvent {
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<String> favoriteProductId;
}
