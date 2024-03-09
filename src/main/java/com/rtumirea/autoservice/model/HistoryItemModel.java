package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryItemModel {
    private Long id;
    private String description;
    private ImageModel imageModel;
    private OrderModel orderModel;
}
