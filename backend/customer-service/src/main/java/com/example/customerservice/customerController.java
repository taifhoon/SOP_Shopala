package com.example.customerservice;

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
        return "Username: " + cus.getUsername() + "\nRole: " + cus.getRole();
    }
}
