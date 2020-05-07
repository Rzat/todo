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
public class MasterShopEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shopName;
    private String address;
    private String parchaType;
    private String city;
    private String district;
    private String groupS;
    private int shopNumber;

}
