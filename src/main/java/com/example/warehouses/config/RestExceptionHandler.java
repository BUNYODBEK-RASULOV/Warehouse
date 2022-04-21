package com.example.warehouses.config;

import com.example.warehouses.exception.product.ProductCustomException;
import com.example.warehouses.exception.product.ProductNotFound;
import com.example.warehouses.model.response.ApiExceptionErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *  SERVICE DA CHIQQIAN HATOLIKNI SHU YERDA USHLAB OLAMIZ
     *  VA UZIMIZ YARATGAN HATOLIK GA BOSHQARIB YUBORAMIZ
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<?> ProductNotFoundException(ProductNotFound e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(ProductCustomException.class)
    public ResponseEntity<?> ProductCustomExceptionException(ProductCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }


}
