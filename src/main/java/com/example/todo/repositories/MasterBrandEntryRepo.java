package com.example.todo.repositories;

import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterBrandEntryRepo extends JpaRepository<MasterBrandNameEntry, Long> {
    MasterBrandNameEntry findByBrandName(String brandName);
}
