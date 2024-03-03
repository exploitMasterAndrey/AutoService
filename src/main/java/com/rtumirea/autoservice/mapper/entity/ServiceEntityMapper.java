package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.ServiceEntity;
import com.rtumirea.autoservice.model.ServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    ServiceEntity toEntity(ServiceModel serviceModel);
}
