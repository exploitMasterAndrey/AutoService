package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.model.ImageModel;
import com.rtumirea.autoservice.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/image")
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/get/{imageId}")
    private ResponseEntity<Resource> getImage(@PathVariable String imageId){
        log.info("Received get image request(imageId={})", imageId);
        ImageModel imageModel = imageService.getImage(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, imageModel.getImageType())
                .body(new ByteArrayResource(imageModel.getImageData()));
    }
}
