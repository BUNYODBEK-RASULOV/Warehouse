package com.example.warehouses.util;

import com.example.warehouses.model.response.ApiResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtils {
    public ApiResponse SUCCESS = new ApiResponse(0, "success");
}
