package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.HistoryItemEntity;
import com.rtumirea.autoservice.model.HistoryItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OrderEntityMapper.class, FileEntityMapper.class}
)
public interface HistoryItemEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "imageEntity", source = "imageModel")
    @Mapping(target = "orderEntity", source = "orderModel")
    HistoryItemEntity toEntity(HistoryItemModel historyItemModel);
}
