package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.RoleEntity;
import com.rtumirea.autoservice.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    RoleModel toModel(RoleEntity roleEntity);
}
