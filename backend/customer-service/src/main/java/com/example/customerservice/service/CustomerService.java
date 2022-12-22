package com.example.customerservice.service;

import com.example.customerservice.command.model.CreateCustomerCommand;
import com.example.customerservice.command.model.CreateCustomerRestModel;
import com.example.customerservice.command.model.UpdateCustomerCommand;
import com.example.customerservice.command.model.UpdateCustomerRestModel;
import com.example.customerservice.query.FindCustomerQuery;
import com.example.customerservice.query.rest.CustomerRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    public CustomerService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "CreateCustomer")
    public String CreateCustomer(CreateCustomerRestModel model){
        CreateCustomerCommand command = CreateCustomerCommand.builder()
                ._id(UUID.randomUUID().toString())
                .username(model.getUsername())
                .password(model.getPassword())
                .name(model.getName())
                .email(model.getEmail())
                .address("")
                .favoriteProductId(new ArrayList<>())
                .cartList(new ArrayList<>())
                .build();

        FindCustomerQuery findCustomerQuery = new FindCustomerQuery();
        List<CustomerRestModel> customers = queryGateway
                .query(findCustomerQuery, ResponseTypes.multipleInstancesOf(CustomerRestModel.class)).join();
        for (CustomerRestModel item:customers) {
            if (item.getUsername().equals(command.getUsername())){
                return "Username: \"" + command.getUsername() + "\" is already use";
            } else if (item.getEmail().equals(command.getEmail())) {
                return "Email: \"" + command.getEmail() + "\" is already use";
            }
        }
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Create Account Complete";
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "UpdateCustomer")
    public String UpdateCustomer(UpdateCustomerRestModel model) {
        UpdateCustomerCommand command = UpdateCustomerCommand.builder()
                ._id(model.get_id())
                .username(model.getUsername())
                .password(model.getPassword())
                .name(model.getName())
                .email(model.getEmail())
                .address(model.getAddress())
                .favoriteProductId(model.getFavoriteProductId())
                .cartList(model.getCartList())
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

    @RabbitListener(queues = "GetCustomers")
    public List<CustomerRestModel> getCustomers(){
        FindCustomerQuery findCustomerQuery = new FindCustomerQuery();
        List<CustomerRestModel> customers = queryGateway
                .query(findCustomerQuery, ResponseTypes.multipleInstancesOf(CustomerRestModel.class)).join();
        return customers;
    }
}
