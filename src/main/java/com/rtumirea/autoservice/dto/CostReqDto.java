package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CostReqDto {
    @NotNull
    @JsonProperty("cost")
    private BigDecimal costAmount;
    @NotNull
    @JsonProperty("car_brand")
    private String carBrand;
    @NotNull
    @JsonProperty("car_model")
    private String carModel;
    @NotNull
    @JsonProperty("service_id")
    private String serviceId;
}
