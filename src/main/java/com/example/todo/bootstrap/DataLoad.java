package com.example.todo.bootstrap;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.BrandType;
import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.MasterBrandEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoad implements CommandLineRunner {
    private final MasterBrandEntryRepo masterBrandEntryRepo;
    private final AddingParchaRepo parchaRepo;

    @Override
    public void run(String... args) throws Exception {
        loadMaster();
    }

    private void loadMaster() {
        MasterBrandNameEntry mb = masterBrandEntryRepo.save(MasterBrandNameEntry.builder()
                .id(1L)
                .brandName("Apple")
                .brandType(BrandType.ENGLISH)
                .changedName("Iphone")
                .brandCategoryName("Electronics")
                .brandCompanyName("Apple")
                .packing1(12)
                .packing2(24)
                .packing3(48)
                .build());

        parchaRepo.save(AddingParcha.builder()
                .id(1L)
                .numbr(10)
                .shopName("abc Tech")
                .nips(300)
                .pints(200)
                .brandName(mb.getBrandName())
                .quarts(100)
             //   .masterBrandNameEntry(mb)
                .build());


    }
}
