package org.example.controller.custom.impl;

import org.example.controller.custom.CustomerController;
import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.example.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@CrossOrigin
public class CustomerControllerImpl implements CustomerController {
    @Autowired
    CustomerService service;
    @PostMapping("/customer")
    @Override
    public CustomerEntity save(@RequestBody CustomerDto customerDto) {
        return service.save(customerDto);
    }
    @DeleteMapping("/customer/{customerId}")
    @Override
    public boolean delete(@PathVariable Long customerId) {
        return service.delete(customerId);
    }
    @GetMapping("/customer")
    @Override
    public List<CustomerDto> getAll() {
        return service.getAll();
    }
    @GetMapping("/customerNextId")
    @Override
    public Long getNextId() throws SQLException {
        return service.getNextId();
    }
    @GetMapping("/customer/{customerId}")
    @Override
    public CustomerDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
