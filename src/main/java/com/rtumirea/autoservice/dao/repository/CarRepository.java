package com.rtumirea.autoservice.dao.repository;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, CarEntity.CarKey> {
}
