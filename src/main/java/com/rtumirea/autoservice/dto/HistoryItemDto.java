package com.rtumirea.autoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class HistoryItemDto {
    @JsonProperty("description")
    private String description;
    @JsonFormat(pattern = "yyyy.MM.dd")
    @JsonProperty("date")
    private LocalDate date;
    @JsonFormat(pattern = "hh:ss")
    @JsonProperty("time")
    private LocalTime time;
    @JsonProperty("image")
    private ImageRspDto image;
}
