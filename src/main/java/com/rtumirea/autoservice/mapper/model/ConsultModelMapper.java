package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.ConsultEntity;
import com.rtumirea.autoservice.dto.CreateConsultReqDto;
import com.rtumirea.autoservice.dto.UpdateConsultReqDto;
import com.rtumirea.autoservice.model.ConsultModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultModelMapper {
    @Mapping(target = "consultId", ignore = true)
    @Mapping(target = "question", source = "question")
    @Mapping(target = "responseDestination", source = "responseDestination")
    @Mapping(target = "responseMethod", source = "responseMethod")
    @Mapping(target = "status", ignore = true)
    ConsultModel toModel(CreateConsultReqDto createConsultReqDto);

    @Mapping(target = "consultId", source = "consultId")
    @Mapping(target = "question", source = "question")
    @Mapping(target = "responseDestination", source = "responseDestination")
    @Mapping(target = "responseMethod", source = "responseMethod")
    @Mapping(target = "status", ignore = true)
    ConsultModel toModel(UpdateConsultReqDto updateConsultReqDto);

    @Mapping(target = "consultId", ignore = true)
    @Mapping(target = "question", source = "question")
    @Mapping(target = "responseDestination", source = "responseDestination")
    @Mapping(target = "responseMethod", source = "responseMethod")
    @Mapping(target = "status", source = "status")
    ConsultModel toModel(ConsultEntity consultEntity);

    List<ConsultModel> toModels(List<ConsultEntity> consultEntities);
}
