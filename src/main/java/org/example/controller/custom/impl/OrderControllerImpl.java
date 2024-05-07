package org.example.controller.custom.impl;

import org.example.controller.custom.OrderController;
import org.example.dto.OrderDto;
import org.example.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@CrossOrigin
public class OrderControllerImpl implements OrderController {
    @Autowired
    OrderService service;
    @PostMapping("/orders")
    @Override
    public OrderDto save(@RequestBody OrderDto orderDto) {
        return service.save(orderDto);
    }
    @DeleteMapping("/orders/{value}")
    @Override
    public boolean delete(@PathVariable Long value) {
        return service.delete(value);
    }
    @GetMapping("/orders")
    @Override
    public List<OrderDto> getAll() {
        return service.getAll();
    }
    @GetMapping("/ordersNextId")
    @Override
    public Long getNextId() throws SQLException { return service.getNextId(); }
    @GetMapping("/orders/{id}")
    @Override
    public OrderDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
}