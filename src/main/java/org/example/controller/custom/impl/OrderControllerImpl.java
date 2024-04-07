package org.example.controller.custom.impl;

import org.example.controller.custom.OrderController;
import org.example.dto.OrderDto;

import java.sql.SQLException;
import java.util.List;

public class OrderControllerImpl implements OrderController {
    @Override
    public OrderDto save(OrderDto orderDto) {
        return null;
    }

    @Override
    public boolean delete(Long value) {
        return false;
    }

    @Override
    public List<OrderDto> getAll() {
        return null;
    }

    @Override
    public Long getNextId() throws SQLException {
        return null;
    }

    @Override
    public OrderDto getById(Long id) {
        return null;
    }
}
