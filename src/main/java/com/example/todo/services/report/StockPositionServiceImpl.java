package com.example.todo.services.report;

import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;
import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import com.example.todo.repositories.MasterBrandEntryRepo;
import com.example.todo.repositories.daily.SaveDailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockPositionServiceImpl implements StockPositionService {

    private final SaveDailySaleRepo saveDailySaleRepo;
    private final MasterBrandEntryRepo masterBrandEntryRepo;

    DecimalFormat df = new DecimalFormat("#.###");

    @Override
    public List<SaveDailySale> findByShopNameAndDate(String shopName, LocalDate date, String type, String packagingType) {
        System.out.println("Shop Name::" + shopName + "Local date is::" + date);
        List<SaveDailySale> saveDailySaleList = saveDailySaleRepo.findAllByShopNameAndDate(shopName, date);
        for (SaveDailySale sale : saveDailySaleList) {
            System.out.println(masterBrandEntryRepo.findByBrandName(sale.getBrandName()));
            if (packagingType.equalsIgnoreCase("C")) {
                MasterBrandNameEntry masterBrandName = (masterBrandEntryRepo.findByBrandName(sale.getBrandName()));
                int packing1 = masterBrandName.getPacking1();
                int packing2 = masterBrandName.getPacking2();
                int packing3 = masterBrandName.getPacking3();

                double qCB = sale.getClosingQuarts();
                double pCB = sale.getClosingPints();
                double nCB = sale.getClosingNips();

                double setClosingQuarts = (qCB) / packing1;
                double setClosingPints = (pCB) / packing2;
                double setClosingNips = (nCB) / packing3;

                sale.setClosingQuarts(Double.parseDouble(df.format(setClosingQuarts)));
                sale.setClosingPints(Double.parseDouble(df.format(setClosingPints)));
                sale.setClosingNips(Double.parseDouble(df.format(setClosingNips)));
            }
        }
        return saveDailySaleList;
    }
}
