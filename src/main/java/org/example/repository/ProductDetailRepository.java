package org.example.repository;

import org.example.entity.ProductDetailEntity;
import org.example.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductDetailRepository extends CrudRepository<ProductDetailEntity,Long> {
}
