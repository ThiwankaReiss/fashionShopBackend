package org.example.service.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.FrockDto;
import org.example.entity.FrockEntity;
import org.example.repository.FrockRepository;
import org.example.service.custom.FrockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class FrockServiceImpl implements FrockService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    FrockRepository frockRepository;
    @Override
    public FrockEntity save(FrockDto frockDto) {
        return frockRepository.save(mapper.convertValue(frockDto, FrockEntity.class));
    }

    @Override
    public boolean delete(Long value) {
        if(frockRepository.findById(value).isPresent()){
            frockRepository.deleteById(value);
            return true;
        }
        return false;
    }

    @Override
    public List<FrockDto> getAll() {
        return StreamSupport.stream(frockRepository.findAll().spliterator(), false)
                .map(entity -> mapper.convertValue(entity, FrockDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long getNextId() throws SQLException {
        return frockRepository.count() + 1;
    }

    @Override
    public FrockDto getById(Long id) {
        return frockRepository.findById(id)
                .map(entity -> mapper.convertValue(entity, FrockDto.class))
                .orElse(null);
    }

    @Override
    public List<FrockDto> getListCustomerId(Long value) {
        return StreamSupport.stream(frockRepository.findByCustomerId(value).spliterator(), false)
                .map(entity -> mapper.convertValue(entity, FrockDto.class))
                .collect(Collectors.toList());
    }
}
