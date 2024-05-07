package org.example.controller.custom;

import org.example.controller.CrudController;
import org.example.dto.ProductDto;
import org.example.entity.ProductDetailEntity;
import org.example.entity.ProductEntity;

import java.util.List;

public interface ProductController extends CrudController<ProductDto, ProductEntity> {

    List<ProductDetailEntity> getListProductId(Long productId);
}
