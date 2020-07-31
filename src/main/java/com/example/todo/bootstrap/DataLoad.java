package com.example.todo.bootstrap;

import com.example.todo.domain.liquorMasterDomain.*;
import com.example.todo.domain.liquorMasterDomain.daily.DailyPurchase;
import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.DailyPurchaseRpo;
import com.example.todo.repositories.MasterBrandEntryRepo;
import com.example.todo.repositories.MasterShopEntryRepo;
import com.example.todo.repositories.daily.DailySaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataLoad implements CommandLineRunner {
    private final MasterBrandEntryRepo masterBrandEntryRepo;
    private final AddingParchaRepo parchaRepo;
    private final MasterShopEntryRepo masterShopEntryRepo;
    private final DailyPurchaseRpo dailyPurchaseRpo;
    private final DailySaleRepo dailySaleRepo;


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

        MasterBrandNameEntry mb2 = masterBrandEntryRepo.save(MasterBrandNameEntry.builder()
                .id(1L)
                .brandName("Orange")
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
                .brandType(BrandType.DESI)
                .groupNumber(4)
                .build());

        parchaRepo.save(AddingParcha.builder()
                .id(2L)
                .numbr(10)
                .shopName("def Tech")
                .nips(150)
                .pints(250)
                .brandName(mb.getBrandName())
                .quarts(3500)
                //   .masterBrandNameEntry(mb)
                .brandType(BrandType.ENGLISH)
                .groupNumber(5)
                .build());

        parchaRepo.save(AddingParcha.builder()
                .id(3L)
                .numbr(10)
                .shopName("abc Tech")
                .nips(30)
                .pints(20)
                .brandName(mb2.getBrandName())
                .quarts(10)
                //   .masterBrandNameEntry(mb)
                .brandType(BrandType.DESI)
                .build());

        masterShopEntryRepo.save(MasterShopEntry.builder()
                .id(1L)
                .groupS("Abc")
                .address("market")
                .city("Hisar")
                .parchaType("Orange")
                .district("Hisr")
                .shopNumber(12)
                .shopName("abc Tech")
                .build());

        DailyPurchase dailyPurchase = new DailyPurchase();
        dailyPurchase.setId(1L);
        dailyPurchase.setDate(new Date());
        dailyPurchase.setPurchaseFrom("abc Tech");
        dailyPurchase.setPurchaseTo("Testing2");
        dailyPurchase.setSize(Size.BOTTLE);
        dailyPurchase.getOrders().add(new Orders("Orange", 122, 133, 155, dailyPurchase));
        dailyPurchase.getOrders().add(new Orders("Apple", 123, 134, 156, dailyPurchase));
        dailyPurchaseRpo.save(dailyPurchase);

        DailySale dailySale = new DailySale(1L, "abc Tech", 12, 13, 4, 5, 6, 7,
                6, 8, 9, 10, 1, 1, 12, 13,
                14, 15, 16, 17, "Orange", LocalDate.now());
        DailySale dailySale2 = new DailySale(2L, "abc Tech", 2, 3, 4, 5, 6, 7,
                8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, "Apple", LocalDate.now());
       /* DailySale dailySale3 = new DailySale(3L, "abc Tech", 2, 3, 4, 5, 6, 7,
                8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, "Apple2", LocalDate.now());*/
        dailySaleRepo.save(dailySale);
        dailySaleRepo.save(dailySale2);
        //dailySaleRepo.save(dailySale3);


    }
}
