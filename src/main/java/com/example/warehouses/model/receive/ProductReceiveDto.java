package com.example.warehouses.model.receive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReceiveDto {
    private String name;
    private double quantity;
}
