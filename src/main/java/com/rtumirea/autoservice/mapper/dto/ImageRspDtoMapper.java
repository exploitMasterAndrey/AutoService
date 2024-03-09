package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ImageRspDto;
import com.rtumirea.autoservice.model.ImageModel;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@DecoratedWith(ImageRspDtoMapperDecorator.class)
public interface ImageRspDtoMapper {
    @Mapping(target = "id", source = "imageId")
    @Mapping(target = "src", ignore = true)
    ImageRspDto toDto(ImageModel imageModel);
}
