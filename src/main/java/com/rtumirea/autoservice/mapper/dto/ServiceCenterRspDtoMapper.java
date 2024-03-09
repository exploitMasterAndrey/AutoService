package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ServiceCenterRspDto;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.core.io.ByteArrayResource;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReviewRspDtoMapper.class, ImageRspDtoMapper.class},
        imports = {ByteArrayResource.class}
)
public interface ServiceCenterRspDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "mainPhone", source = "mainPhone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "imageRspDto", source = "imageModel")
    @Mapping(target = "reviewRspDtos", source = "reviewModels")
    ServiceCenterRspDto toDto(ServiceCenterModel serviceCenterModel);

    List<ServiceCenterRspDto> toDtos(List<ServiceCenterModel> serviceCenterModels);
}
