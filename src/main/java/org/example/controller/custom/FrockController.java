package org.example.controller.custom;

import org.example.controller.CrudController;
import org.example.dto.FrockDto;
import org.example.entity.FrockEntity;

import java.util.List;

public interface FrockController extends CrudController <FrockDto, FrockEntity>{
    List<FrockDto> getListCustomerId(Long value);
}
