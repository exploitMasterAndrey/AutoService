package com.rtumirea.autoservice.dao.repository;

import com.rtumirea.autoservice.dao.entity.CostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostRepository extends JpaRepository<CostEntity, Long> {
    @Query("select cst from CostEntity cst " +
            "join fetch cst.carEntity cr " +
            "join fetch cst.serviceEntity srvc " +
            "where cr.brand = :carBrand and cr.model = :carModel and srvc.id = :serviceId")
    Optional<CostEntity> findCostByCarBrandAndCarModelAndServiceId(
            @Param("carBrand") String carBrand,
            @Param("carModel") String carModel,
            @Param("serviceId") String serviceId
    );
}
