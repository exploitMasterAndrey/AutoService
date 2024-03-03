package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CostModel {
    private BigDecimal costAmount;
    private String carBrand;
    private String carModel;
    private String serviceId;
}
