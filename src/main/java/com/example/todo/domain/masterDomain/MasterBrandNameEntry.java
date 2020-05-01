package com.example.todo.domain.masterDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class MasterBrandNameEntry {

    @Id
    private Long id;
    private String brandName;
    private String changedName;
    private String brandType;
    private int packing1;
    private int packing2;
    private int packing3;
}
