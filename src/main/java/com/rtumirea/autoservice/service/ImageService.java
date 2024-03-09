package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.FileEntity;
import com.rtumirea.autoservice.dao.repository.FileRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.model.ImageModelMapper;
import com.rtumirea.autoservice.model.ImageModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
    private final FileRepository fileRepository;
    private final ImageModelMapper imageModelMapper;

    public ImageModel getImage(String uuid){
        log.info("Getting image(uuid={})", uuid);
        Optional<FileEntity> optFile = fileRepository.findById(UUID.fromString(uuid));
        if (optFile.isPresent()){
            FileEntity imageEntity = optFile.get();
            return imageModelMapper.toModel(imageEntity);
        } else {
            String message = String.format("Unable to find image(%s)", uuid);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }
}
