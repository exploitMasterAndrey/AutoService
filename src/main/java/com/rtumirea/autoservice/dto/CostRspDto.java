package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CostRspDto {
    @JsonProperty("cost")
    private BigDecimal costAmount;
    @JsonProperty("car_brand")
    private String carBrand;
    @JsonProperty("car_model")
    private String carModel;
    @JsonProperty("service_id")
    private String serviceId;
}
