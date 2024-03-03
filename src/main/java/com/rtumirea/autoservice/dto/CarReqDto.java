package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CarReqDto {
    @NotNull
    @JsonProperty("brand")
    private String brand;
    @NotNull
    @JsonProperty("model")
    private String model;
    @NotNull
    @JsonProperty("description")
    private String description;
}
