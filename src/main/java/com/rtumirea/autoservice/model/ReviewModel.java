package com.rtumirea.autoservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class ReviewModel {
    private Long id;
    private String comment;
    private UserModel userModel;
    private ServiceCenterModel serviceCenterModel;
}
