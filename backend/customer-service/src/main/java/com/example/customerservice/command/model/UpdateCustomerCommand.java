package com.example.customerservice.command.model;

import com.example.customerservice.pojo.Cart;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Builder
@Data
public class UpdateCustomerCommand {
    @TargetAggregateIdentifier
    private String _id;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<String> favoriteProductId;
    private List<Cart> cartList;
    private String tel;
}
