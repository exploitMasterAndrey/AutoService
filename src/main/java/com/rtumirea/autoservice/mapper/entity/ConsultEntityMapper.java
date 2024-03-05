package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.ConsultEntity;
import com.rtumirea.autoservice.model.ConsultModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "question", source = "question")
    @Mapping(target = "responseDestination", source = "responseDestination")
    @Mapping(target = "responseMethod", source = "responseMethod")
    @Mapping(target = "status", source = "status")
    ConsultEntity toEntity(ConsultModel consultModel);
}
