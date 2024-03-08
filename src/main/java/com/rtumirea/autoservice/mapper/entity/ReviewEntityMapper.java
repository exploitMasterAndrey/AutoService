package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.ReviewEntity;
import com.rtumirea.autoservice.model.ReviewModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ServiceCenterEntityMapper.class, UserEntityMapper.class}
)
public interface ReviewEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "userEntity", source = "userModel")
    @Mapping(target = "serviceCenterEntity", source = "serviceCenterModel")
    ReviewEntity toEntity(ReviewModel reviewModel);
}
