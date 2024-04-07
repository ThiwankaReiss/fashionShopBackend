package org.example.service.custom;

import org.example.dto.CustomerDto;
import org.example.dto.OrderDto;
import org.example.entity.CustomerEntity;
import org.example.service.CrudService;

public interface OrderService extends CrudService<OrderDto, OrderDto> {
}
