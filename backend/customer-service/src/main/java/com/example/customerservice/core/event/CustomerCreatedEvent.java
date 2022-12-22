package com.example.customerservice.core.event;

import com.example.customerservice.pojo.Cart;
import lombok.Data;

import java.util.List;

@Data
public class CustomerCreatedEvent {
    private String _id;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<String> favoriteProductId;
    private List<Cart> cartList;
    private String tel;
}
