package com.example.customerservice.command.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateCustomerRestModel implements Serializable {
    private String password;
    private String name;
    private String email;
    private String tel;
}
