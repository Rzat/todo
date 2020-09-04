package com.example.todo.repositories;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddingParchaRepo extends JpaRepository<AddingParcha, Long> {
    //Optional<AddingParcha> findByShopName(String purchaseFrom);

    List<AddingParcha> findAllByShopName(String purchaseFrom);

    Optional<AddingParcha> findByShopNameAndBrandName(String shopName, String brandName);

    AddingParcha findByShopName(String purchaseFrom);

    AddingParcha findByBrandNameAndShopName(String brandName, String shopName);
}
