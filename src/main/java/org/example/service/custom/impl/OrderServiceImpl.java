package org.example.service.custom.impl;

import org.example.dto.OrderDto;
import org.example.entity.OrderDetailsEntity;
import org.example.entity.OrderEntity;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderDetailRepository;
import org.example.repository.OrderRepository;
import org.example.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailRepository detailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDto save(OrderDto orderDto) {
        OrderEntity order=orderRepository.save(
                new OrderEntity(orderDto.getId(), 
                        orderDto.getTotalPrice(), 
                        orderDto.getDiscountedPrice(), 
                        orderDto.getCustomerId(), 
                        orderDto.getDate()));
        for (OrderDetailsEntity detail:orderDto.getList()) {
            detail.setOrderId(order.getId());
            detailRepository.save(detail);
        }
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
