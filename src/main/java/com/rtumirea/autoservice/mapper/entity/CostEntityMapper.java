package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import com.rtumirea.autoservice.dao.entity.CostEntity;
import com.rtumirea.autoservice.dao.entity.ServiceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.math.BigDecimal;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CostEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "costAmount", source = "costAmount")
    @Mapping(target = "carEntity", source = "carEntity")
    @Mapping(target = "serviceEntity", source = "serviceEntity")
    CostEntity toEntity(BigDecimal costAmount, CarEntity carEntity, ServiceEntity serviceEntity);
}
