package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.OrderEntity;
import com.rtumirea.autoservice.dao.entity.OrderShortEntity;
import com.rtumirea.autoservice.mapper.CycleAvoidingMappingContext;
import com.rtumirea.autoservice.model.OrderModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {HistoryItemModelMapper.class, UserModelMapper.class}
)
public interface OrderModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "orderStatus", source = "orderStatus")
    @Mapping(target = "historyItemModels", source = "historyItemEntities")
    @Mapping(target = "userModel", source = "userEntity")
    OrderModel toModel(OrderEntity orderEntity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    List<OrderModel> toModels(List<OrderEntity> orderEntities, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "orderStatus", source = "orderStatus")
    @Mapping(target = "historyItemModels", ignore = true)
    @Mapping(target = "userModel", source = "userEntity")
    OrderModel toShortModel(OrderShortEntity orderShortEntity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    List<OrderModel> toShortModels(List<OrderShortEntity> orderShortEntities, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
