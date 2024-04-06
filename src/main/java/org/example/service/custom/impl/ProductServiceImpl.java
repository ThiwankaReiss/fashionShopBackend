package org.example.service.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.ProductDto;
import org.example.entity.CustomerEntity;
import org.example.entity.ProductDetailEntity;
import org.example.entity.ProductEntity;
import org.example.repository.ProductDetailRepository;
import org.example.repository.ProductRepository;
import org.example.service.custom.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductDto productDto) {

        return productRepository.save(mapper.convertValue(productDto, ProductEntity.class));
    }
    @Override
    public boolean delete(Long value) {
        if(productRepository.findById(value).isPresent()){
            productRepository.deleteById(value);
            return true;
        }
        return false;
    }
    @Override
    public List<ProductDto> getAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(entity -> mapper.convertValue(entity, ProductDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Long getNextId() throws SQLException {
        return productRepository.count() + 1;
    }
    @Override
    public ProductDto getById(Long id) {
        return productRepository.findById(id)
                .map(entity -> mapper.convertValue(entity, ProductDto.class))
                .orElse(null);
    }
}