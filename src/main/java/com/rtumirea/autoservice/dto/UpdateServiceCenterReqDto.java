package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateServiceCenterReqDto {
    @NotNull
    @JsonProperty("service_id")
    private Long serviceId;
    @NotNull
    @JsonProperty("main_phone")
    private String phone;
    @NotNull
    @JsonProperty("address")
    private String address;
    @NotNull
    @JsonProperty("image")
    private UpdateImageDto image;
}
