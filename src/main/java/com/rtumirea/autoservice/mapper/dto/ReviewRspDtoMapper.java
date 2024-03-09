package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ReviewRspDto;
import com.rtumirea.autoservice.model.ReviewModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewRspDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "creatorFullName", source = "userModel.fullName")
    @Mapping(target = "creatorEmail", source = "userModel.email")
    ReviewRspDto toDto(ReviewModel reviewModel);
}
