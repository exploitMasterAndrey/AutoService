package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.HistoryItemEntity;
import com.rtumirea.autoservice.dto.CreateHistoryItemReqDto;
import com.rtumirea.autoservice.model.HistoryItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDateTime;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {OrderModelMapper.class, ImageModelMapper.class},
        imports = {LocalDateTime.class}
)
public interface HistoryItemModelMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "imageModel", source = "fileEntity")
    @Mapping(target = "orderModel", source = "orderEntity")
    HistoryItemModel toModel(HistoryItemEntity historyItemEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "description")
    @Mapping(target = "createdAt", expression = "java( LocalDateTime.now() )")
    @Mapping(target = "imageModel", source = "image", qualifiedByName = "toCreateModel")
    @Mapping(target = "orderModel", ignore = true)
    HistoryItemModel toModel(CreateHistoryItemReqDto createHistoryItemReqDto);
}
