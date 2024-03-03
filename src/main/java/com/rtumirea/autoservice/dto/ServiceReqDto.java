package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceReqDto {
    @NotNull
    @JsonProperty("id")
    private String id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    @JsonProperty("description")
    private String description;
}
