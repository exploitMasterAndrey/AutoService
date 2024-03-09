package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.ServiceCenterEntity;
import com.rtumirea.autoservice.dao.entity.ServiceCenterShortEntity;
import com.rtumirea.autoservice.dto.CreateServiceCenterReqDto;
import com.rtumirea.autoservice.dto.UpdateServiceCenterReqDto;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.io.IOException;
import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReviewModelMapper.class, ImageModelMapper.class}
)
public interface ServiceCenterModelMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mainPhone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "imageModel", source = "image", qualifiedByName = "toCreateModel")
    @Mapping(target = "reviewModels", ignore = true)
    ServiceCenterModel toModel(CreateServiceCenterReqDto createServiceCenterReqDto) throws IOException;

    @Mapping(target = "id", source = "serviceId")
    @Mapping(target = "mainPhone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "imageModel", source = "image", qualifiedByName = "toUpdateModel")
    @Mapping(target = "reviewModels", ignore = true)
    ServiceCenterModel toModel(UpdateServiceCenterReqDto updateServiceCenterReqDto) throws IOException;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "mainPhone", source = "mainPhone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "imageModel", source = "fileEntity")
    @Mapping(target = "reviewModels", source = "reviewEntities")
    ServiceCenterModel toModel(ServiceCenterEntity serviceCenterEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "mainPhone", source = "mainPhone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "imageModel", source = "fileEntity")
    @Mapping(target = "reviewModels", ignore = true)
    ServiceCenterModel toModel(ServiceCenterShortEntity serviceCenterShortEntity);

    List<ServiceCenterModel> toModels(List<ServiceCenterShortEntity> serviceCenterShortEntity);
}
