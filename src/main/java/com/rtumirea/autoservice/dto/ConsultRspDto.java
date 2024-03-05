package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ConsultRspDto {
    @JsonProperty("question")
    private String question;
    @JsonProperty("rsp_destination")
    private String responseDestination;
    @JsonProperty("rsp_method")
    private String responseMethod;
    @JsonProperty("consult_status")
    private String status;
}
