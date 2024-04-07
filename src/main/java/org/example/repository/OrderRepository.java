package org.example.repository;

import org.example.entity.OrderEntity;
import org.example.entity.ProductDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
}
