package com.example.warehouses.entity.warehousesEntity;

import com.example.warehouses.entity.baseEntity.BaseEntity;
import com.example.warehouses.entity.materialEntity.MaterialEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class WarehousesEntity extends BaseEntity {
    @ManyToOne
    private MaterialEntity materialEntity;
    private double remainder;
    private double price;

}
