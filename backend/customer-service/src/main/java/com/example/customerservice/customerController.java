package com.example.customerservice;

import com.example.customerservice.command.model.CreateCustomerRestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class customerController {
    @GetMapping
    public String getCustomer(){
        return "Create Success ";
    }

    @PostMapping
    public String createCustomer(@RequestBody CreateCustomerRestModel cus){
        return "Username: " + cus.getUsername();
    }
}
