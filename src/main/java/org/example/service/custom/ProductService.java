package org.example.service.custom;

import org.example.dto.ProductDto;
import org.example.entity.ProductDetailEntity;
import org.example.entity.ProductEntity;
import org.example.service.CrudService;

import java.util.List;

public interface ProductService extends CrudService<ProductDto, ProductEntity> {

    List<ProductDetailEntity> getListProductId(Long value);
}
