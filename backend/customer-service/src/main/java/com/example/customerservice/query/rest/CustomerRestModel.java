package com.example.customerservice.query.rest;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CustomerRestModel implements Serializable {
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<String> favoriteProductId;
}
