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
    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private FileEntity fileEntity;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE},
            mappedBy = "serviceCenterEntity"
    )
    private List<ReviewEntity> reviewEntities;
}
