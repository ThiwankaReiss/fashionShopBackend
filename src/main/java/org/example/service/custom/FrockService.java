package org.example.service.custom;

import org.example.dto.FrockDto;
import org.example.entity.FrockEntity;
import org.example.service.CrudService;

import java.util.List;

public interface FrockService extends CrudService <FrockDto, FrockEntity>{
    List<FrockDto> getListCustomerId(Long value);
}
