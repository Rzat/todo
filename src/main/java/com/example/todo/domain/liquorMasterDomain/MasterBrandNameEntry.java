package com.example.todo.domain.liquorMasterDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class MasterBrandNameEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String changedName;
    private String brandCompanyName;
    private String brandCategoryName;
    private BrandType brandType;
    private int packing1;
    private int packing2;
    private int packing3;

    // @OneToOne(fetch = FetchType.EAGER)
    // private AddingParcha addingParcha;
}
