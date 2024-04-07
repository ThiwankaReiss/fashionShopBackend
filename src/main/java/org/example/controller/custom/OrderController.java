package org.example.controller.custom;

import org.example.controller.CrudController;
import org.example.dto.OrderDto;
import org.example.dto.ProductDto;
import org.example.entity.ProductEntity;

public interface OrderController extends CrudController<OrderDto, OrderDto> {
}
