package com.rtumirea.autoservice.dao.repository;

import com.rtumirea.autoservice.dao.entity.OrderEntity;
import com.rtumirea.autoservice.dao.entity.OrderShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Query("select o from OrderEntity o " +
            "left join fetch o.userEntity")
    List<OrderShortEntity> findAllOrders();

    @Query("select o from OrderEntity o " +
            "join fetch o.userEntity u " +
            "where u.email = :email")
    List<OrderShortEntity> findAllOrdersWhereUserEmail(@Param("email") String email);

    @Query("select o from OrderEntity o " +
            "left join fetch o.userEntity " +
            "left join fetch o.historyItemEntities " +
            "where o.id = :id")
    Optional<OrderEntity> findOrderById(@Param("id") Long id);
}
