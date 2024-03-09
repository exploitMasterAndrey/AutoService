package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateReviewReqDto {
    @NotNull
    @JsonProperty("review_id")
    private Long reviewId;
    @NotNull
    @JsonProperty("user_comment")
    private String userComment;
}
