package com.example.sellerservice.command.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateSellerCommand {
    @TargetAggregateIdentifier
    private String _id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;
    private String bank;
    private String accountNumber;
}
