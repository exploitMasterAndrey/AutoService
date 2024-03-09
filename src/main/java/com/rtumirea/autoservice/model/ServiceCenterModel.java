package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ServiceCenterModel {
    private Long id;
    private String mainPhone;
    private String address;
    private ImageModel imageModel;
    private List<ReviewModel> reviewModels;
}
