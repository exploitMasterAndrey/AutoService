package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.NewCarRspDto;
import com.rtumirea.autoservice.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NewCarRspDtoMapper {
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "description", source = "description")
    NewCarRspDto toDto(CarModel carModel);
}
