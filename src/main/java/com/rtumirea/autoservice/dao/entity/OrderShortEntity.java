package com.rtumirea.autoservice.dao.entity;

import com.rtumirea.autoservice.enums.OrderStatus;

import java.time.LocalDateTime;

public interface OrderShortEntity {
    Long getId();
    String getComment();
    LocalDateTime getDateTime();
    OrderStatus getOrderStatus();
    UserEntity getUserEntity();
}
