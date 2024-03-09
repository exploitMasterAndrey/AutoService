package com.rtumirea.autoservice.mapper.model;

import com.rtumirea.autoservice.dao.entity.FileEntity;
import com.rtumirea.autoservice.dto.UpdateImageDto;
import com.rtumirea.autoservice.model.ImageModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {UUID.class}
)
public interface ImageModelMapper {
    @Mapping(target = "imageId", source = "fileId")
    @Mapping(target = "imageType", source = "fileType")
    @Mapping(target = "imageData", source = "fileData")
    ImageModel toModel(FileEntity fileEntity);

    @Named(value = "toCreateModel")
    @Mapping(target = "imageId", expression = "java( UUID.randomUUID() )")
    @Mapping(target = "imageType", expression = "java( multipartFile.getContentType() )")
    @Mapping(target = "imageData", expression = "java( multipartFile.getBytes() )")
    ImageModel toCreateModel(MultipartFile multipartFile) throws IOException;

    @Named(value = "toUpdateModel")
    @Mapping(target = "imageId", source = "id")
    @Mapping(target = "imageType", expression = "java( updateImageDto.getData().getContentType() )")
    @Mapping(target = "imageData", expression = "java( updateImageDto.getData().getBytes() )")
    ImageModel toModel(UpdateImageDto updateImageDto) throws IOException;
}
