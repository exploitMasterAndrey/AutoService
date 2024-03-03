package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.CostEntity;
import com.rtumirea.autoservice.dto.CostReqDto;
import com.rtumirea.autoservice.model.CostModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CostModelMapper {
    @Mapping(target = "costAmount", source = "costAmount")
    @Mapping(target = "carBrand", source = "carBrand")
    @Mapping(target = "carModel", source = "carModel")
    @Mapping(target = "serviceId", source = "serviceId")
    CostModel toModel(CostReqDto costReqDto);

    @Mapping(target = "costAmount", source = "costAmount")
    @Mapping(target = "carBrand", source = "carEntity.brand")
    @Mapping(target = "carModel", source = "carEntity.model")
    @Mapping(target = "serviceId", source = "serviceEntity.id")
    CostModel toModel(CostEntity costEntity);
}
