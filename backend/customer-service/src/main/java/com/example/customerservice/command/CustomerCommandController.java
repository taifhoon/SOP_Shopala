package com.example.customerservice.command;

import com.example.customerservice.command.model.CreateCustomerCommand;
import com.example.customerservice.command.model.CreateCustomerRestModel;
import com.example.customerservice.command.model.UpdateCustomerCommand;
import com.example.customerservice.command.model.UpdateCustomerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerCommandController {
    private final CommandGateway commandGateway;

    @Autowired
    public CustomerCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
    public String createCustomer(@RequestBody CreateCustomerRestModel model){

        CreateCustomerCommand command = CreateCustomerCommand.builder()
                ._id(UUID.randomUUID().toString())
                .username(model.getUsername())
                .password(model.getPassword())
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress())
                .build();

        String result;
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@RequestBody UpdateCustomerRestModel model){
        UpdateCustomerCommand command = UpdateCustomerCommand.builder()
                ._id(model.get_id())
                .username(model.getUsername())
                .password(model.getPassword())
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Update Success Customer Id: " + command.get_id() + "\nName: "+ command.getUsername();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
