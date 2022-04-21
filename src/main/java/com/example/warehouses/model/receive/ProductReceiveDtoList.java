package com.example.warehouses.model.receive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductReceiveDtoList {
    private List<ProductReceiveDto>productReceiveDtoList;
}
