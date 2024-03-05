package com.rtumirea.autoservice.dao.repository;

import com.rtumirea.autoservice.dao.entity.ConsultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends JpaRepository<ConsultEntity, Long> {
}
