package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CreateOrderRspDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("comment")
    private String comment;
    @JsonFormat(pattern = "yyyy.MM.dd")
    @JsonProperty("order_date")
    private LocalDate orderDate;
    @JsonFormat(pattern = "hh:ss")
    @JsonProperty("order_time")
    private LocalTime orderTime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("user_email")
    private String userEmail;
}
