package org.example.repository;

import org.example.entity.FrockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FrockRepository extends CrudRepository<FrockEntity,Long> {
    List<FrockEntity> findByCustomerId(Long productId);
}
