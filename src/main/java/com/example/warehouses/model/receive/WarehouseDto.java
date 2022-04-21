package com.example.warehouses.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseDto {
    private String product_name;
    private double product_qty;
    private List<ProductMaterial>product_materials;
}
