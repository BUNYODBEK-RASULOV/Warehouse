package com.example.warehouses.entity.productEntity;

import com.example.warehouses.entity.baseEntity.BaseEntity;
import com.example.warehouses.entity.productMaterialEntity.ProductMaterialEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@Entity
public class ProductEntity extends BaseEntity {
    @Column(unique = true,nullable = false)
    private String name;
    private String code;


    @OneToMany(mappedBy = "productEntity")
    private List<ProductMaterialEntity>productMaterialEntities;

}
