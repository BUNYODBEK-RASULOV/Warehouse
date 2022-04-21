package com.example.warehouses.service.productService;

import com.example.warehouses.entity.productEntity.ProductEntity;
import com.example.warehouses.entity.productMaterialEntity.ProductMaterialEntity;
import com.example.warehouses.entity.warehousesEntity.WarehousesEntity;
import com.example.warehouses.exception.product.ProductNotFound;
import com.example.warehouses.model.receive.ProductReceiveDto;
import com.example.warehouses.model.receive.ProductReceiveDtoList;
import com.example.warehouses.model.receive.ProductMaterial;
import com.example.warehouses.model.receive.WarehouseDto;
import com.example.warehouses.model.response.ApiResponse;
import com.example.warehouses.repository.productRepository.ProductRepository;
import com.example.warehouses.service.Database;
import com.example.warehouses.service.baseService.BaseService;
import com.example.warehouses.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService extends Database implements BaseService<ProductReceiveDtoList> {

    @Autowired
    ProductRepository productRepository;
    private final ResponseUtils responseUtils;


    /**
     *productlarni ismi bilan topib beradi data basedan ( har biriga qancha maxsulot ketishini bilish uchun )
     */
    public ProductEntity getProductByName(String name){
        Optional<ProductEntity> byName = productRepository.findByName(name);
        if (byName.isEmpty())
            throw new ProductNotFound("name="+name+" not found");
        return byName.get();
    }

    /**
     *frontendan kelgan productlarni bittalab olamiz
     */
    @Override
    public ApiResponse addList(ProductReceiveDtoList productReceiveDtoList){
        addWarehouse();
        ApiResponse success = responseUtils.SUCCESS;
        List<WarehouseDto>warehouseReceiveDtoList=new ArrayList<>();
        for (ProductReceiveDto p : productReceiveDtoList.getProductReceiveDtoList()) {
            WarehouseDto warehouseReceiveDto=new WarehouseDto();
                warehouseReceiveDto.setProduct_name(p.getName());
                warehouseReceiveDto.setProduct_qty(p.getQuantity());
                warehouseReceiveDto.setProduct_materials(product_material(p.getName(),p.getQuantity()));
                warehouseReceiveDtoList.add(warehouseReceiveDto);
        }
        success.setData(warehouseReceiveDtoList);
        clearWarehouse();
        return success;
    }

    /**
     * productdagi maxsulotlarni bittalab olamiz
     */
    public List<ProductMaterial>product_material(String name, double qty){
        List<ProductMaterial>productMaterials=new ArrayList<>();
        for (ProductMaterialEntity pme : getProductByName(name).getProductMaterialEntities()) {
            pme.setQuantity(pme.getQuantity()*qty);
            productMaterials.addAll(logic(pme));
        }
        return productMaterials;
    }


    /**
     * asosiy logika
     */
    public List<ProductMaterial> logic(ProductMaterialEntity pme){
        List<ProductMaterial>list=new ArrayList<>();
        for (WarehousesEntity w : warehouses) {
            if (!w.getMaterialEntity().getName().equals(pme.getMaterialEntity().getName()) || w.getRemainder() == 0)
                continue;

            if (pme.getQuantity() == 0)
                return list;

            if (pme.getQuantity() <= w.getRemainder()) {
                list.add(new ProductMaterial(w.getId(), pme.getMaterialEntity().getName(), pme.getQuantity(), w.getPrice()));
                w.setRemainder(w.getRemainder() - pme.getQuantity());
                pme.setQuantity(0);
                return list;
            } else {
                list.add(new ProductMaterial(w.getId(), pme.getMaterialEntity().getName(), w.getRemainder(), w.getPrice()));
                pme.setQuantity(pme.getQuantity() - w.getRemainder());
                w.setRemainder(0);
            }
        }
        if (pme.getQuantity()>0)
            list.add(new ProductMaterial(0, pme.getMaterialEntity().getName(), pme.getQuantity(), 0));
        return list;
    }


}
