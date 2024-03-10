package com.rtumirea.autoservice.model;

import com.rtumirea.autoservice.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@Setter
public class OrderModel {
    private Long id;
    private String comment;
    private LocalDateTime dateTime;
    private OrderStatus orderStatus;
    private List<HistoryItemModel> historyItemModels;
    private UserModel userModel;

    public OrderModel(String comment, UserModel userModel, LocalDateTime localDateTime){
        this.comment = comment;
        this.userModel = userModel;
        this.dateTime = localDateTime;
    }
}
