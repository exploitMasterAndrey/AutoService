package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.config.properties.NonRegisterStubProperties;
import com.rtumirea.autoservice.dto.UserDto;
import com.rtumirea.autoservice.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class UserDtoMapperDecorator implements UserDtoMapper {
    @Autowired
    private NonRegisterStubProperties nonRegisterStubProperties;
    @Autowired
    @Qualifier("delegate")
    private UserDtoMapper delegate;

    @Override
    public UserDto toDto(UserModel userModel) {
        UserDto dto = delegate.toDto(userModel);
        if (dto == null){
            dto = UserDto.builder()
                    .phone(nonRegisterStubProperties.getPhone())
                    .fullName(nonRegisterStubProperties.getFullName())
                    .build();
        }
        return dto;
    }
}
