package com.example.todo.repositories;

import com.example.todo.domain.liquorMasterDomain.daily.DailyPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyPurchaseRpo extends JpaRepository<DailyPurchase, Long> {
}
