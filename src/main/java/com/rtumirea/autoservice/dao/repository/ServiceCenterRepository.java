package com.rtumirea.autoservice.dao.repository;

import com.rtumirea.autoservice.dao.entity.ServiceCenterEntity;
import com.rtumirea.autoservice.dao.entity.ServiceCenterShortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenterEntity, Long> {
    @Query("select sc from ServiceCenterEntity sc")
    List<ServiceCenterShortEntity> getAllServiceCenters();
}
