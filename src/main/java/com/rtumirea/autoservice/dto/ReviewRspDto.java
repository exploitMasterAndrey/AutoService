package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRspDto {
    @JsonProperty("review_id")
    private Long id;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("creator_full_name")
    private String creatorFullName;
    @JsonProperty("creator_email")
    private String creatorEmail;
}
