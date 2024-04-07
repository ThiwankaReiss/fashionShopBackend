package org.example.repository;

import org.example.entity.ProductDetailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDetailRepository extends CrudRepository<ProductDetailEntity,Long> {
    List<ProductDetailEntity> findByProductId(Long productId);
}
