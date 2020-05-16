package com.example.todo.repositories;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddingParchaRepo extends JpaRepository<AddingParcha, Long> {
    Optional<AddingParcha> findByShopName(String purchaseFrom);
}
