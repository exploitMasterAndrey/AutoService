package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.HistoryItemEntity;
import com.rtumirea.autoservice.model.HistoryItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OrderModelMapper.class, ImageModelMapper.class}
)
public interface HistoryItemModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "imageModel", source = "imageEntity")
    @Mapping(target = "orderModel", source = "orderEntity")
    HistoryItemModel toModel(HistoryItemEntity historyItemEntity);
}
