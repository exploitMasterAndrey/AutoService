package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class OrderRspDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("comment")
    private String comment;
    @JsonFormat(pattern = "yyyy.MM.dd")
    @JsonProperty("date")
    private LocalDate date;
    @JsonFormat(pattern = "hh:ss")
    @JsonProperty("time")
    private LocalTime time;
    @JsonProperty("status")
    private String status;
    @JsonProperty("history")
    private List<HistoryItemDto> history;
    @JsonProperty("user")
    private UserDto user;
}
