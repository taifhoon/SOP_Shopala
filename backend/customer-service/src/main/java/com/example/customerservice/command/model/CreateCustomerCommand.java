package com.example.customerservice.command.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Builder
@Data
public class CreateCustomerCommand {
    @TargetAggregateIdentifier
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private List<String> favoriteProductId;
}
