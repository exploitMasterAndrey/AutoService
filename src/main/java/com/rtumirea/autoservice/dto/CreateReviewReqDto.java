package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateReviewReqDto {
    @NotNull
    @JsonProperty("user_comment")
    private String userComment;
    @NotNull
    @JsonProperty("user_email")
    private String userEmail;
    @NotNull
    @JsonProperty("service_id")
    private Long serviceId;
}
