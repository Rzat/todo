package com.example.todo.services;

import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;

import java.util.List;

public interface MasterBrandEntryService {
    MasterBrandNameEntry savMasterBrandNameEntry(MasterBrandNameEntry masterBrandNameEntry);

    List<MasterBrandNameEntry> findAll();

    MasterBrandNameEntry getBrandById(Long id);

    Boolean deleteBrandById(Long id);
}
