package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.ServiceEntity;
import com.rtumirea.autoservice.dto.ServiceReqDto;
import com.rtumirea.autoservice.model.ServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    ServiceModel toModel(ServiceReqDto serviceReqDto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    ServiceModel toModel(ServiceEntity serviceEntity);
}
