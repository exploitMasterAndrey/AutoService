package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.UserDto;
import com.rtumirea.autoservice.model.UserModel;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@DecoratedWith(UserDtoMapperDecorator.class)
public interface UserDtoMapper {
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "phone", source = "phone")
    UserDto toDto(UserModel userModel);
}
