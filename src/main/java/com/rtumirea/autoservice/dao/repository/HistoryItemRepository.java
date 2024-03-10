package com.rtumirea.autoservice.dao.repository;

import com.rtumirea.autoservice.dao.entity.HistoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryItemRepository extends JpaRepository<HistoryItemEntity, Long> {
}
