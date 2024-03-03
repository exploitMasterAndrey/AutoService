package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import com.rtumirea.autoservice.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarEntityMapper {
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "description", source = "description")
    CarEntity toEntity(CarModel carModel);
}
