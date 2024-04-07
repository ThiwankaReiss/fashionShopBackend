package org.example.service.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.CustomerDto;
import org.example.entity.CustomerEntity;
import org.example.repository.CustomerRepository;
import org.example.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerEntity save(CustomerDto customerDto) {
        return customerRepository.save(mapper.convertValue(customerDto,CustomerEntity.class));
    }
    @Override
    public boolean delete(Long value) {
        if(customerRepository.findById(value).isPresent()){
            customerRepository.deleteById(value);
            return true;
        }
        return false;
    }
    @Override
    public List<CustomerDto> getAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(entity -> mapper.convertValue(entity, CustomerDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Long getNextId() throws SQLException {
        return customerRepository.count() + 1;
    }
    @Override
    public CustomerDto getById(Long id) {
        return customerRepository.findById(id)
                .map(entity -> mapper.convertValue(entity, CustomerDto.class))
                .orElse(null);
    }
}
