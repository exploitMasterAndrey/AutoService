package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.UserEntity;
import com.rtumirea.autoservice.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleModelMapper.class, OrderModelMapper.class}
)
public interface UserModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "roleModels", source = "roleEntities")
    @Mapping(target = "orderModels", source = "orderEntities")
    UserModel toModel(UserEntity userEntity);
}
