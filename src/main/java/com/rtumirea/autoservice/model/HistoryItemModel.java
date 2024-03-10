package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryItemModel {
    private Long id;
    private String description;
    private LocalDateTime createdAt;
    private ImageModel imageModel;
    private OrderModel orderModel;
}
