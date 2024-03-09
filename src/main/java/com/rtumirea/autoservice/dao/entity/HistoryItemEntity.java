package com.rtumirea.autoservice.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "history")
@NoArgsConstructor
public class HistoryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_seq_gen")
    @SequenceGenerator(name = "history_seq_gen", sequenceName = "history_seq", allocationSize = 1)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToOne(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private FileEntity imageEntity;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity orderEntity;
}
