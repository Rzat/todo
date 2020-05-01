package com.example.todo.bootstrap;

import com.example.todo.domain.masterDomain.MasterBrandNameEntry;
import com.example.todo.repositories.MasterBrandEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoad implements CommandLineRunner {
    private final MasterBrandEntryRepo masterBrandEntryRepo;

    @Override
    public void run(String... args) throws Exception {
        loadMaster();
    }

    private void loadMaster() {
        masterBrandEntryRepo.save(MasterBrandNameEntry.builder()
                .id(1L)
                .brandName("BP")
                .brandType("ENGLISH")
                .changedName("Blenders")
                .packing1(12)
                .packing2(24)
                .packing3(48)
                .build());
    }
}
