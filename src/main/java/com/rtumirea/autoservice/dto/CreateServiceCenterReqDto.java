package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@ToString(exclude = {"image"})
@Getter
@Setter
public class CreateServiceCenterReqDto {
    @NotNull
    @JsonProperty("main_phone")
    private String phone;
    @NotNull
    @JsonProperty("address")
    private String address;
    @NotNull
    @JsonProperty("image")
    private MultipartFile image;
}
