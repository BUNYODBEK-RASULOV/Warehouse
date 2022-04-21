package com.example.warehouses.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMaterial {
    private long warehouse_id;
    private String material_name;
    private double qty;
    private double price;
}
