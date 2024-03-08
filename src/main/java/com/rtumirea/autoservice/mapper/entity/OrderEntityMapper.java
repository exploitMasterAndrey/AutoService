package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.OrderEntity;
import com.rtumirea.autoservice.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {HistoryItemEntityMapper.class, UserEntityMapper.class}
)
public interface OrderEntityMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "historyItemEntities", source = "historyItemModels")
    @Mapping(target = "userEntity", source = "userModel")
    OrderEntity toEntity(OrderModel orderModel);
}
