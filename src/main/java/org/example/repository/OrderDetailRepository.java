package org.example.repository;

import org.example.entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetailsEntity,Long> {
}
