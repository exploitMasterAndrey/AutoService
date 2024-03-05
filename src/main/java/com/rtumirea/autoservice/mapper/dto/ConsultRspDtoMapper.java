package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ConsultRspDto;
import com.rtumirea.autoservice.model.ConsultModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultRspDtoMapper {
    @Mapping(target = "question", source = "question")
    @Mapping(target = "responseDestination", source = "responseDestination")
    @Mapping(target = "responseMethod", source = "responseMethod")
    @Mapping(target = "status", source = "status.description")
    ConsultRspDto toDto(ConsultModel consultModel);

    List<ConsultRspDto> toDtos(List<ConsultModel> consultModel);
}
