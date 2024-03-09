package com.rtumirea.autoservice.mapper.dto;

import com.rtumirea.autoservice.dto.ImageRspDto;
import com.rtumirea.autoservice.model.ImageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class ImageRspDtoMapperDecorator implements ImageRspDtoMapper {
    @Autowired
    @Qualifier("delegate")
    private ImageRspDtoMapper delegate;
    @Value("${app.config.image-management.get.path}")
    private String getImageUrl;

    @Override
    public ImageRspDto toDto(ImageModel imageModel){
        ImageRspDto imageRspDto = delegate.toDto(imageModel);
        String resultImageUrl = String.format(getImageUrl, imageModel.getImageId());
        String uriString = ServletUriComponentsBuilder.fromCurrentRequestUri().replacePath(resultImageUrl).toUriString();
        imageRspDto.setSrc(uriString);
        return imageRspDto;
    }
}
