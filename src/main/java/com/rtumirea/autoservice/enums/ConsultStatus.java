package com.rtumirea.autoservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConsultStatus {
    REQUESTED("Запрошена"),
    IN_PROGRESS("В процессе"),
    DONE("Завершена");

    private final String description;

    public ConsultStatus safeValueOf(String description){
        for (var status: ConsultStatus.values()){
            if (status.description.equals(description))
                return status;
        }
        return null;
    }
}
