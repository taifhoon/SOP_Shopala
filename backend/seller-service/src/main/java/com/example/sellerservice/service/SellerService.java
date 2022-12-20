package com.example.sellerservice.service;

import com.example.sellerservice.command.model.CreateSellerCommand;
import com.example.sellerservice.command.model.CreateSellerRestModel;
import com.example.sellerservice.command.model.UpdateSellerCommand;
import com.example.sellerservice.command.model.UpdateSellerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SellerService {
    private final CommandGateway commandGateway;

    @Autowired
    public SellerService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "CreateSeller")
    public String createSeller(CreateSellerRestModel model){
        CreateSellerCommand command = CreateSellerCommand.builder()
                ._id(UUID.randomUUID().toString())
                .username(model.getUsername())
                .password(model.getPassword())
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress())
                .bank(model.getBank())
                .accountNumber(model.getAccountNumber())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "UpdateSeller")
    public String UpdateSeller(UpdateSellerRestModel model) {
        UpdateSellerCommand command = UpdateSellerCommand.builder()
                ._id(model.get_id())
                .username(model.getUsername())
                .password(model.getPassword())
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress())
                .bank(model.getBank())
                .accountNumber(model.getAccountNumber())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Update Success Seller Id: " + command.get_id() + "\nName: "+ command.getUsername();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
