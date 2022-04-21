package com.example.warehouses.entity.baseEntity;

import lombok.*;
import javax.persistence.*;

/**
 * DASTURCHI --> RASULOV BUNYOD
 * YARTILDI --> 03.04.2022  TIME TUNGI 1:37
 * TEL --> +99 99 668 56 99
 */
@Setter
@Getter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
