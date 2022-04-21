package com.example.warehouses.controller.baseController;

import com.example.warehouses.model.receive.ProductReceiveDtoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public interface BaseController<T> {
    ResponseEntity<?> addList(@RequestBody ProductReceiveDtoList list);
}
