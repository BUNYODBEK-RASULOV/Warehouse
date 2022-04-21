package com.example.warehouses.exception.product;

public class ProductCustomException extends RuntimeException{
    /**
     * HATOLIKLARNI QAYTARISH UCHUN UZIM YARATGAN EXCEPTION
     */
    public ProductCustomException() {
    }

    public ProductCustomException(String message) {
        super(message);
    }

    public ProductCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductCustomException(Throwable cause) {
        super(cause);
    }

    public ProductCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
