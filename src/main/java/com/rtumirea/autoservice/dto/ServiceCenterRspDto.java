package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceCenterRspDto {
    @JsonProperty("service_id")
    private Long id;
    @JsonProperty("main_phone")
    private String mainPhone;
    @JsonProperty("address")
    private String address;
    @JsonProperty("image")
    private ImageRspDto imageRspDto;
    @JsonProperty("reviews")
    private List<ReviewRspDto> reviewRspDtos;
}
