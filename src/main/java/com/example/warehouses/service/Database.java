package com.example.warehouses.service;

import com.example.warehouses.entity.warehousesEntity.WarehousesEntity;
import com.example.warehouses.repository.warehouseRepository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import java.util.List;

public abstract class Database {
    @Autowired
    WarehouseRepository warehouseRepository;

    /**
     * DB --> DATA BASE
     * Warehouse listni DB olib vaqtincha shu yerda saqliymiz( DB o'zgarib ketmaslik uchun )
     * DB ulanishlar sonini ham kamaytiramiz shu usul orqali.
     */
    public static List<WarehousesEntity> warehouses;

    /**
     * har safar funksiya ishlaganda DB dan malumotni oladi.
     */
    public void addWarehouse(){
        warehouses=warehouseRepository.findAll(Sort.by("price"));
    }

    /**
     * funksiya ishini yakunlagach list ni tozalab quyadi.
     */
    public void clearWarehouse(){
        warehouses=null;
    }
}
