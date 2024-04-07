package org.example.service.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.ProductDto;
import org.example.entity.ProductDetailEntity;
import org.example.entity.ProductEntity;
import org.example.repository.ProductDetailRepository;
import org.example.repository.ProductRepository;
import org.example.service.custom.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDetailRepository detailRepository;

    @Override
    public ProductEntity save(ProductDto productDto) {

        ProductEntity entity=productRepository.save(mapper.convertValue(productDto,ProductEntity.class));
        detailRepository.save(new ProductDetailEntity(
                null,entity.getCurrentPrice(),
                entity.getDiscount(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                LocalTime.now().format( DateTimeFormatter.ofPattern("h.mm a")),
                entity.getId()));
        return entity;
    }
    @Override
    public boolean delete(Long value) {
        if(productRepository.findById(value).isPresent()){
            List<ProductDetailEntity> productDetails = detailRepository.findByProductId(value);
            detailRepository.deleteAll(productDetails);
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

    @Override
    public List<ProductDetailEntity> getListProductId(Long value) {
        System.out.println(detailRepository.findByProductId(value));
        return detailRepository.findByProductId(value);
    }
}