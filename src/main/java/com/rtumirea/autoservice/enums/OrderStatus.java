package com.rtumirea.autoservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    REQUESTED("Создан"),
    IN_PROGRESS("В процессе"),
    DONE("Завершен");

    private final String description;

    public static OrderStatus safeValueOf(String description){
        for (var status: OrderStatus.values()){
            if (status.description.equals(description))
                return status;
        }
        return null;
    }
}
