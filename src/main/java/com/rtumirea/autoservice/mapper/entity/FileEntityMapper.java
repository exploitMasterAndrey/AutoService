package com.rtumirea.autoservice.mapper.entity;

import com.rtumirea.autoservice.dao.entity.FileEntity;
import com.rtumirea.autoservice.model.ImageModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FileEntityMapper {
    @Mapping(target = "fileId", source = "imageId")
    @Mapping(target = "fileType", source = "imageType")
    @Mapping(target = "fileData", source = "imageData")
    FileEntity toEntity(ImageModel imageModel);
}
