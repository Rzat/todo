package com.example.todo.services;

import com.example.todo.domain.masterDomain.MasterBrandNameEntry;
import com.example.todo.repositories.MasterBrandEntryRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MasterBrandEntryServiceImpl implements MasterBrandEntryService {

    private final MasterBrandEntryRepo masterBrandEntryRepo;

    @Override
    public MasterBrandNameEntry savMasterBrandNameEntry(MasterBrandNameEntry masterBrandNameEntry) {
        return masterBrandEntryRepo.save(masterBrandNameEntry);
    }

    @Override
    public void findAll() {
        masterBrandEntryRepo.findAll();
    }
}
