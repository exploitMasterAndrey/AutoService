package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@ToString
@Getter
@Setter
public class CreateOrderReqDto {
    @JsonProperty("user_email")
    private String userEmail;
    @NotNull
    @JsonProperty("user_comment")
    private String userComment;
    @NotNull
    @JsonFormat(pattern = "yyyy.MM.dd")
    @JsonProperty("order_date")
    private LocalDate orderDate;
    @NotNull
    @JsonFormat(pattern = "HH:mm")
    @JsonProperty("order_time")
    private LocalTime orderTime;
}
