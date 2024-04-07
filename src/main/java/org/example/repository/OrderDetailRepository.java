package org.example.repository;

import org.example.entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailRepository extends CrudRepository<OrderDetailsEntity,Long> {
    List<OrderDetailsEntity> findByOrderId(Long productId);
}
