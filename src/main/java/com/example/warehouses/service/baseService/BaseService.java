package com.example.warehouses.service.baseService;

import com.example.warehouses.model.response.ApiResponse;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface BaseService<T> {
    ApiResponse addList(T t);
}
