package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.ReviewEntity;
import com.rtumirea.autoservice.model.ReviewModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserModelMapper.class, ServiceCenterModelMapper.class}
)
public interface ReviewModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "userModel", source = "userEntity")
    @Mapping(target = "serviceCenterModel", source = "serviceCenterEntity")
    ReviewModel toModel(ReviewEntity reviewEntity);
}
