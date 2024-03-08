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
    private byte[] image;
    private List<ReviewModel> reviewModels;
}
