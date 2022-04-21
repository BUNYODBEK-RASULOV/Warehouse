package com.example.warehouses.controller.productController;

import com.example.warehouses.controller.baseController.BaseController;
import com.example.warehouses.model.receive.ProductReceiveDto;
import com.example.warehouses.model.receive.ProductReceiveDtoList;
import com.example.warehouses.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController implements BaseController<ProductReceiveDtoList> {

    @Autowired
    ProductService productService;

    /**
     *
     * PUT http://localhost:8080/api/addList
     * Content-Type: application/json
     *
     * {
     *   "productReceiveDtoList":[
     *     {
     *     "name":"Koylak",
     *     "quantity":"30"
     *     },
     *     {
     *       "name":"Shim",
     *       "quantity":"20"
     *     }
     *   ]
     * }
     */

    @PutMapping("/addList")
    @Override
    public ResponseEntity<?> addList(ProductReceiveDtoList list){
        return ResponseEntity.ok(productService.addList(list));
    }

}
