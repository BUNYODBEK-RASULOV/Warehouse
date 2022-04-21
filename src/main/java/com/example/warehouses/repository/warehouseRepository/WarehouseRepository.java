package com.example.warehouses.repository.warehouseRepository;

import com.example.warehouses.entity.warehousesEntity.WarehousesEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WarehouseRepository extends JpaRepository<WarehousesEntity,Long> {
    @Query("select w from WarehousesEntity w")
    @Override
    <S extends WarehousesEntity> List<S> findAll(Example<S> example, Sort sort);
}
