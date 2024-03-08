package com.rtumirea.autoservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderModel {
    private Long id;
    private String comment;
    private List<HistoryItemModel> historyItemModels;
    private UserModel userModel;
}
