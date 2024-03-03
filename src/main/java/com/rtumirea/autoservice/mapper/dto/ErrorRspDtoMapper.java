package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ErrorRspDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ErrorRspDtoMapper {
    @Mapping(target = "error", source = "message")
    ErrorRspDto toDto(Exception e);
}
