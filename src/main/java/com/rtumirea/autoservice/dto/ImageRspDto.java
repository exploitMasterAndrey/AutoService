package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageRspDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("src")
    private String src;
}
