package org.example.controller.custom.impl;

import org.example.controller.custom.ProductController;
import org.example.dto.ProductDto;
import org.example.entity.ProductDetailEntity;
import org.example.entity.ProductEntity;
import org.example.service.custom.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@CrossOrigin
public class ProductControllerImpl implements ProductController {
    @Autowired
    ProductService service;
    @PostMapping("/product")
    @Override
    public ProductEntity save(@RequestBody ProductDto productDto) { return service.save(productDto);}
    @DeleteMapping("/product/{productId}")
    @Override
    public boolean delete(@PathVariable Long productId) { return service.delete(productId);}
    @GetMapping("/product")
    @Override
    public List<ProductDto> getAll() { return service.getAll();}
    @GetMapping("/productNextId")
    @Override
    public Long getNextId() throws SQLException { return service.getNextId();}
    @GetMapping("/product/{productId}")
    @Override
    public ProductDto getById(@PathVariable Long productId) { return service.getById(productId);}
    @GetMapping("/product/history/{productId}")
    @Override
    public List<ProductDetailEntity> getListProductId(@PathVariable Long productId) { return service.getListProductId(productId);}
}