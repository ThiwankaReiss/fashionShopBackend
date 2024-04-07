package org.example.service.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.OrderDto;
import org.example.entity.OrderDetailsEntity;
import org.example.entity.OrderEntity;
import org.example.repository.OrderDetailRepository;
import org.example.repository.OrderRepository;
import org.example.service.custom.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailRepository detailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public OrderDto save(OrderDto orderDto) {
        OrderEntity order = orderRepository.save(new OrderEntity(
                orderDto.getId(),
                orderDto.getTotalPrice(),
                orderDto.getDiscountedPrice(),
                orderDto.getCustomerId(),
                orderDto.getDate(),
                orderDto.getTime()
        ));

        List<OrderDetailsEntity> details = orderDto.getList().stream()
                .peek(detail -> detail.setOrderId(order.getId()))
                .collect(Collectors.toList());
        detailRepository.saveAll(details);

        return getById(order.getId());
    }

    @Override
    public boolean delete(Long value) {
        if(orderRepository.findById(value).isPresent()){
            List<OrderDetailsEntity> orderDetails = detailRepository.findByOrderId(value);
            detailRepository.deleteAll(orderDetails);
            orderRepository.deleteById(value);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderDto> getAll() {
       List<OrderEntity> orders=StreamSupport.stream(orderRepository.findAll().spliterator(), false).collect(Collectors.toList());
       List<OrderDto> dtoList=new ArrayList<>();
        for (OrderEntity entity:orders) {

            dtoList.add(
                    new OrderDto(
                            entity.getId(),
                            entity.getTotalPrice(),
                            entity.getDiscountedPrice(),
                            entity.getCustomerId(),
                            entity.getDate(),
                            entity.getTime(),
                            detailRepository.findByOrderId(entity.getId())
                    )
            );
        }
        return dtoList;
    }

    @Override
    public Long getNextId() throws SQLException {
        return orderRepository.count() + 1;
    }

    @Override
    public OrderDto getById(Long id) {
        OrderEntity order=orderRepository.findById(id).orElse(null);
        if(order !=null){
            return new OrderDto(
                    order.getId(),
                    order.getTotalPrice(),
                    order.getDiscountedPrice(),
                    order.getCustomerId(),
                    order.getDate(),
                    order.getTime(),
                    detailRepository.findByOrderId(order.getId())
            );
        }
        return null;
    }
}
