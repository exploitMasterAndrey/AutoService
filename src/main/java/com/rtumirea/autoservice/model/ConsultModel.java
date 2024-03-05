package com.rtumirea.autoservice.model;

import com.rtumirea.autoservice.enums.ConsultResponseMethod;
import com.rtumirea.autoservice.enums.ConsultStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ConsultModel {
    private Long consultId;
    private String question;
    private String responseDestination;
    private ConsultResponseMethod responseMethod;
    private ConsultStatus status;
}
