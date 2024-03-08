package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewModel {
    private Long id;
    private String comment;
    private UserModel userModel;
    private ServiceCenterModel serviceCenterModel;
}
