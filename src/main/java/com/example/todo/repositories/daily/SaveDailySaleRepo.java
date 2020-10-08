package com.example.todo.repositories.daily;

import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaveDailySaleRepo extends JpaRepository<SaveDailySale, Long> {
    List<SaveDailySale> findAllByShopNameAndDate(String shopName, LocalDate date);

    List<SaveDailySale> findAllByCityNameAndDate(String cityName, LocalDate date);

    List<SaveDailySale> findAllByDistrictNameAndDate(String districtName, LocalDate date);

    @Query(value = "SELECT e FROM SaveDailySale e WHERE e.shopName=:shopName AND e.date BETWEEN :startDate AND :endDate")
    List<SaveDailySale> getAllShopBetweenDates(@Param("shopName") String shopName, @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);


}
