package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@ToString(exclude = {"data"})
@Getter
@Setter
public class UpdateImageDto {
    @NotNull
    @JsonProperty("id")
    private String id;
    @NotNull
    @JsonProperty("data")
    private MultipartFile data;
}
