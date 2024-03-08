package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.OrderEntity;
import com.rtumirea.autoservice.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {HistoryItemModelMapper.class, UserModelMapper.class}
)
public interface OrderModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "historyItemModels", source = "historyItemEntities")
    @Mapping(target = "userModel", source = "userEntity")
    OrderModel toModel(OrderEntity orderEntity);
}
