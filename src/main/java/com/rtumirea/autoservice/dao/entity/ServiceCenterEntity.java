package com.rtumirea.autoservice.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "service_center")
@NoArgsConstructor
public class ServiceCenterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_center_seq_gen")
    @SequenceGenerator(name = "service_center_seq_gen", sequenceName = "service_center_seq", allocationSize = 1)
    private Long id;
    @Column(name = "main_phone", nullable = false)
    private String mainPhone;
    @Column(name = "address", nullable = false)
    private String address;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @OneToMany(
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "serviceCenterEntity"
    )
    private List<ReviewEntity> reviewEntities;
}
