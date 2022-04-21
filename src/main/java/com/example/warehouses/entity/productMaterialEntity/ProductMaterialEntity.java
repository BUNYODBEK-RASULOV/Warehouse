package com.example.warehouses.entity.productMaterialEntity;

import com.example.warehouses.entity.baseEntity.BaseEntity;
import com.example.warehouses.entity.materialEntity.MaterialEntity;
import com.example.warehouses.entity.productEntity.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Setter
@Getter
@Entity
public class ProductMaterialEntity extends BaseEntity {

    @JsonIgnore
    @ManyToOne
    private ProductEntity productEntity;

    @ManyToOne
    private MaterialEntity materialEntity;

    private double quantity;
}
