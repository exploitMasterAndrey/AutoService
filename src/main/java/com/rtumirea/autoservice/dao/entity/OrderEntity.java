package com.rtumirea.autoservice.dao.entity;

import com.rtumirea.autoservice.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order_")
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen", sequenceName = "order_seq", allocationSize = 1)
    private Long id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus orderStatus;
    @OneToMany(
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "orderEntity"
    )
    private List<HistoryItemEntity> historyItemEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;
}
