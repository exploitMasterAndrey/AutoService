package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ServiceCenterRspDto;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.core.io.ByteArrayResource;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReviewRspDtoMapper.class},
        imports = {ByteArrayResource.class}
)
public interface ServiceCenterRspDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "mainPhone", source = "mainPhone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "image", expression = "java( new ByteArrayResource(serviceCenterModel.getImage()) )")
    @Mapping(target = "reviewRspDtos", source = "reviewModels")
    ServiceCenterRspDto toDto(ServiceCenterModel serviceCenterModel);
}
