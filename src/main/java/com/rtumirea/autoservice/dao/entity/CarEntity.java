package com.rtumirea.autoservice.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "car")
@NoArgsConstructor
@IdClass(CarEntity.CarKey.class)
public class CarEntity {
    @Id
    @Column(name = "brand", nullable = false)
    private String brand;
    @Id
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "description")
    private String description;

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class CarKey implements Serializable{
        private String brand;
        private String model;
    }
}
