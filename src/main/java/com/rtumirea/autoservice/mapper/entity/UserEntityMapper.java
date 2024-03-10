package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.UserEntity;
import com.rtumirea.autoservice.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleEntityMapper.class, OrderEntityMapper.class}
)
public interface UserEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "roleEntities", source = "roleModels")
    @Mapping(target = "orderEntities", source = "orderModels")
    @Mapping(target = "authorities", ignore = true)
    UserEntity toEntity(UserModel userModel);
}
