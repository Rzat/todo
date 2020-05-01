package com.example.todo.services;

import com.example.todo.domain.masterDomain.MasterBrandNameEntry;

public interface MasterBrandEntryService {
    MasterBrandNameEntry savMasterBrandNameEntry(MasterBrandNameEntry masterBrandNameEntry);

    void findAll();
}
