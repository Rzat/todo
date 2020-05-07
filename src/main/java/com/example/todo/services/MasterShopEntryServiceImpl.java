package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.MasterShopEntry;
import com.example.todo.repositories.MasterShopEntryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MasterShopEntryServiceImpl implements MasterShopEntryService {

    private final MasterShopEntryRepo shopEntryRepo;

    @Override
    public MasterShopEntry save(MasterShopEntry entry) {
        return shopEntryRepo.save(entry);
    }
}
