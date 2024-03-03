package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.CostRspDto;
import com.rtumirea.autoservice.model.CostModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CostRspDtoMapper {
    @Mapping(target = "costAmount", source = "costAmount")
    @Mapping(target = "carBrand", source = "carBrand")
    @Mapping(target = "carModel", source = "carModel")
    @Mapping(target = "serviceId", source = "serviceId")
    CostRspDto toDto(CostModel costModel);
}
