package org.example.controller.custom.impl;

import org.example.controller.custom.FrockController;
import org.example.dto.FrockDto;
import org.example.entity.FrockEntity;
import org.example.service.custom.FrockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@CrossOrigin
public class FrockControllerImpl implements FrockController {
    @Autowired
    FrockService service;
    @PostMapping("/frock")
    @Override
    public FrockEntity save(@RequestBody FrockDto frockDto) {
        return service.save(frockDto);
    }
    @DeleteMapping("/frock/{value}")
    @Override
    public boolean delete(@PathVariable Long value) {
        return service.delete(value);
    }
    @GetMapping("/frock")
    @Override
    public List<FrockDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/frockNextId")
    @Override
    public Long getNextId() throws SQLException {
        return service.getNextId();
    }

    @GetMapping("/frock/{frockId}")
    @Override
    public FrockDto getById(@PathVariable Long frockId) {
        return service.getById(frockId);
    }
    @GetMapping("/frock/customer/{customerId}")
    @Override
    public List<FrockDto> getListCustomerId(@PathVariable Long customerId) {
        return service.getListCustomerId(customerId);
    }
}
