package com.example.todo.repositories.daily;

import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailySaleRepo extends JpaRepository<DailySale, Long> {
    List<DailySale> findAllByShopName(String shopName);

    DailySale findByShopNameAndBrandName(String shopName, String brandName);

}
