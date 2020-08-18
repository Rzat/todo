package com.example.todo.repositories;

import com.example.todo.domain.liquorMasterDomain.MasterShopEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterShopEntryRepo extends JpaRepository<MasterShopEntry, Long> {
    MasterShopEntry getByShopName(String shopName);

}
