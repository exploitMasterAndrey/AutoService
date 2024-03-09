package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.ServiceCenterEntity;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ReviewEntityMapper.class, FileEntityMapper.class}
)
public interface ServiceCenterEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "mainPhone", source = "mainPhone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "fileEntity", source = "imageModel")
    @Mapping(target = "reviewEntities", source = "reviewModels")
    ServiceCenterEntity toEntity(ServiceCenterModel serviceCenterModel);
}
