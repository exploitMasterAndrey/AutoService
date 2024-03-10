package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("phone")
    private String phone;
}
