package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UpdateConsultReqDto {
    @NotNull
    @JsonProperty("consult_id")
    private Long consultId;
    @NotNull
    @JsonProperty("rsp_destination")
    private String responseDestination;
    @NotNull
    @JsonProperty("rsp_method")
    private String responseMethod;
    @JsonProperty("question")
    private String question;
}
