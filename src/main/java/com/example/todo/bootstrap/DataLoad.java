package com.example.todo.bootstrap;

import com.example.todo.domain.liquorMasterDomain.*;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.DailyPurchaseRpo;
import com.example.todo.repositories.MasterBrandEntryRepo;
import com.example.todo.repositories.MasterShopEntryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataLoad implements CommandLineRunner {
    private final MasterBrandEntryRepo masterBrandEntryRepo;
    private final AddingParchaRepo parchaRepo;
    private final MasterShopEntryRepo masterShopEntryRepo;
    private final DailyPurchaseRpo dailyPurchaseRpo;

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


//
//        dailyPurchaseRpo.save(DailyPurchase.builder()
//                .id(1L)
//                .purchaseCode("1")
//                .date(new Date())
//                .purchaseFrom("abc Tech")
//                .purchaseTo("Testing2")
//                .size(Size.BOTTLE)
//                .build());

        DailyPurchase dailyPurchase = new DailyPurchase();
        dailyPurchase.setId(1L);
        dailyPurchase.setDate(new Date());
        dailyPurchase.setPurchaseFrom("abc Tech");
        dailyPurchase.setPurchaseTo("Testing2");
        dailyPurchase.setSize(Size.BOTTLE);
        dailyPurchase.getOrders().add(new Orders("Orange", 122, 133, 155, dailyPurchase));
        dailyPurchase.getOrders().add(new Orders("Apple", 123, 134, 156, dailyPurchase));
        dailyPurchaseRpo.save(dailyPurchase);


    }
}
