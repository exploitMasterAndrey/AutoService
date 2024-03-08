package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.RoleEntity;
import com.rtumirea.autoservice.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    RoleEntity toEntity(RoleModel roleModel);
}
