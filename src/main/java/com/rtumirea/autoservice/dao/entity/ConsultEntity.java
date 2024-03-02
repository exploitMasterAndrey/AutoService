package com.rtumirea.autoservice.dao.entity;

import com.rtumirea.autoservice.enums.ConsultResponseMethod;
import com.rtumirea.autoservice.enums.ConsultStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "consult")
@NoArgsConstructor
public class ConsultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consult_seq_gen")
    @SequenceGenerator(name = "consult_seq_gen", sequenceName = "consult_seq", allocationSize = 1)
    private Long id;
    @Column(name = "question", nullable = false)
    private String question;
    @Column(name = "rsp_destination", nullable = false)
    private String responseDestination;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "rsp_method", nullable = false)
    private ConsultResponseMethod responseMethod = ConsultResponseMethod.EMAIL;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ConsultStatus status = ConsultStatus.REQUESTED;
}
