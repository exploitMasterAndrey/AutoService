package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import com.rtumirea.autoservice.dto.CarReqDto;
import com.rtumirea.autoservice.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarModelMapper {
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "description", source = "description")
    CarModel toModel(CarReqDto carReqDto);

    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "description", source = "description")
    CarModel toModel(CarEntity carEntity);

    List<CarModel> toModels(List<CarEntity> carEntities);
}
