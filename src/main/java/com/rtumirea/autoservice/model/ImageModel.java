package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ImageModel {
    private UUID imageId;
    private String imageType;
    private byte[] imageData;
}
