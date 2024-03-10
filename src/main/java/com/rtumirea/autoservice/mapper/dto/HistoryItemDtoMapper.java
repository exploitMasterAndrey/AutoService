package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.HistoryItemDto;
import com.rtumirea.autoservice.model.HistoryItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ImageRspDtoMapper.class}
)
public interface HistoryItemDtoMapper {
    @Mapping(target = "description", source = "description")
    @Mapping(target = "date", expression = "java( historyItemModel.getCreatedAt().toLocalDate() )")
    @Mapping(target = "time", expression = "java( historyItemModel.getCreatedAt().toLocalTime() )")
    @Mapping(target = "image", source = "imageModel")
    HistoryItemDto toDto(HistoryItemModel historyItemModel);

    List<HistoryItemDto> toDtos(List<HistoryItemModel> historyItemModels);
}
