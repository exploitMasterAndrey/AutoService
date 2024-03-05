package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ServiceRspDto;
import com.rtumirea.autoservice.model.ServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceRspDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    ServiceRspDto toDto(ServiceModel serviceModel);
    List<ServiceRspDto> toDtos(List<ServiceModel> serviceModel);
}
