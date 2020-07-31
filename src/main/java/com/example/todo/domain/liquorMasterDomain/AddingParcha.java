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
@Builder
@RequiredArgsConstructor
public class AddingParcha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shopName;
    private int numbr;
    private int quarts;
    private int pints;
    private int nips;
    private String brandName;
    private BrandType brandType;
    private int groupNumber;

    // @OneToOne(fetch = FetchType.EAGER)
    //  private MasterBrandNameEntry masterBrandNameEntry;

}
