package com.example.orderservice.service;

import com.example.orderservice.command.model.CreateOrderCommand;
import com.example.orderservice.command.model.CreateOrderRestModel;
import com.example.orderservice.command.model.DelOrderCommand;
import com.example.orderservice.command.model.DelOrderRestModel;
import com.example.orderservice.query.FindOrderQuery;
import com.example.orderservice.query.rest.OrderRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    public OrderService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @RabbitListener(queues = "CreateOrder")
    public String CreateProduct(CreateOrderRestModel model){
        CreateOrderCommand command = CreateOrderCommand.builder()
                ._id(UUID.randomUUID().toString())
                .productId(model.getProductId())
                .customerId(model.getCustomerId())
                .paymentId(model.getPaymentId())
                .build();
        String result= "";
        try {
            result = commandGateway.sendAndWait(command);
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "DeleteOrder")
    public String DeleteOrder(DelOrderRestModel model){
        DelOrderCommand command = DelOrderCommand.builder()
                ._id(model.get_id())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(command);
            result = "Delete Success \nOrder Id: " + command.get_id();
        } catch (Exception e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RabbitListener(queues = "GetOrders")
    public List<OrderRestModel> getOrders(){
        FindOrderQuery findOrderQuery = new FindOrderQuery();
        List<OrderRestModel> orders = queryGateway
                .query(findOrderQuery, ResponseTypes.multipleInstancesOf(OrderRestModel.class)).join();
        return orders;
    }
}
