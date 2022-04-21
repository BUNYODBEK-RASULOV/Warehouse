package com.example.warehouses.entity.materialEntity;

import com.example.warehouses.entity.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;


@Setter
@Getter
@Entity
public class MaterialEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String name;




}
