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
public class CreateHistoryItemReqDto {
    @NotNull
    @JsonProperty("order_id")
    private Long orderId;
    @NotNull
    @JsonProperty("description")
    private String description;
    @NotNull
    @JsonProperty("image")
    private MultipartFile image;
}
