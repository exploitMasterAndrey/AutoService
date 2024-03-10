package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Valid
public class SetOrderStatusReqDto {
    @NotNull
    @JsonProperty("order_id")
    private Long orderId;
    @NotNull
    @JsonProperty("status")
    private String status;
}
