package org.example.controller.custom.impl;

import org.example.dto.CustomerDto;
import org.example.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {
    @Autowired
    CustomerService service;
    @PostMapping("/auth")
    public CustomerDto authCustomer(@RequestBody CustomerDto customerDto) {
        return service.authCustomer(customerDto);
    }
}
