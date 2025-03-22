package com.eazybytes.accounts.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//MappedSuperclass  annotation is act as a super class for other entity class

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEnity {

    @Column(updatable = false) 
    private LocalDateTime createdAt;

    @Column(updatable = false) 
    private String createdBy;

    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;



}
