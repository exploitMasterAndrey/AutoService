package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.CreateOrderRspDto;
import com.rtumirea.autoservice.dto.OrderRspDto;
import com.rtumirea.autoservice.model.OrderModel;
import com.rtumirea.autoservice.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Optional;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Optional.class, UserModel.class},
        uses = {HistoryItemDtoMapper.class, UserDtoMapper.class}
)
public interface OrderRspDtoMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "orderDate", expression = "java( orderModel.getDateTime().toLocalDate() )")
    @Mapping(target = "orderTime", expression = "java( orderModel.getDateTime().toLocalTime() )")
    @Mapping(target = "status", source = "orderStatus.description")
    @Mapping(target = "userEmail", expression = "java( Optional.ofNullable(orderModel.getUserModel()).map(UserModel::getEmail).orElse(\"без регистрации\") )")
    CreateOrderRspDto toCreationDto(OrderModel orderModel);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "date", expression = "java( orderModel.getDateTime().toLocalDate() )")
    @Mapping(target = "time", expression = "java( orderModel.getDateTime().toLocalTime() )")
    @Mapping(target = "status", source = "orderStatus.description")
    @Mapping(target = "history", source = "historyItemModels")
    @Mapping(target = "user", source = "userModel")
    OrderRspDto toDto(OrderModel orderModel);

    List<OrderRspDto> toDtos(List<OrderModel> orderModels);
}
