package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.MasterShopEntry;

import java.util.List;

public interface MasterShopEntryService {
    MasterShopEntry save(MasterShopEntry entry);

    List<MasterShopEntry> getShop();
}
