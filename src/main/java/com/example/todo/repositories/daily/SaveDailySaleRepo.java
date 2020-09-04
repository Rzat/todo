package com.example.todo.repositories.daily;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaveDailySaleRepo extends JpaRepository<SaveDailySale, Long> {
    List<SaveDailySale> findAllByShopNameAndDate(String shopName, LocalDate date);

    List<SaveDailySale> findAllByCityNameAndDate(String cityName, LocalDate date);
}
