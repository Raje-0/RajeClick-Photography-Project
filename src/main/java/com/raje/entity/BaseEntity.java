package com.raje.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
