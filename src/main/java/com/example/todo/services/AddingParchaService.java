package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;

import java.util.List;

public interface AddingParchaService {
    List<AddingParcha> findAll();

    AddingParcha saveParcha(AddingParcha parcha);

    List<AddingParcha> findByShopName(String shopName);

    AddingParcha findByShopAndBrandName(String shopName, String brandName);
}
