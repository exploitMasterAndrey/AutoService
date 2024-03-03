package com.rtumirea.autoservice.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(
        name = "cost",
        indexes = @Index(
                name = "idx_cost",
                columnList = "car_brand, car_model, service_id",
                unique = true
        )
)
@NoArgsConstructor
public class CostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_seq_gen")
    @SequenceGenerator(name = "cost_seq_gen", sequenceName = "cost_seq", allocationSize = 1)
    private Long id;
    @Column(name = "cost_amount", nullable = false)
    private BigDecimal costAmount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "car_brand", referencedColumnName = "brand"),
            @JoinColumn(name = "car_model", referencedColumnName = "model")
    })
    private CarEntity carEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private ServiceEntity serviceEntity;
}
