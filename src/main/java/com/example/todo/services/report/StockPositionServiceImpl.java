package com.example.todo.services.report;

import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.BrandType;
import com.example.todo.domain.liquorMasterDomain.MasterBrandNameEntry;
import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.MasterBrandEntryRepo;
import com.example.todo.repositories.daily.SaveDailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockPositionServiceImpl implements StockPositionService {

    private final SaveDailySaleRepo saveDailySaleRepo;
    private final MasterBrandEntryRepo masterBrandEntryRepo;
    private final AddingParchaRepo parchaRepo;

    DecimalFormat df = new DecimalFormat("#.###");


    @Override
    public List findStockByCity(String cityName, LocalDate localDate, String type, String packagingType) {
        List<SaveDailySale> findAllByCity = saveDailySaleRepo.findAllByCityNameAndDate(cityName, localDate);
        List<SaveDailySale> returnList = new ArrayList<>();
        getBySaveDailySale(type, packagingType, findAllByCity, returnList);
        return returnList;
    }

    @Override
    public List findByDistrict(String districtName, LocalDate localDate, String type, String packagingType) {
        List<SaveDailySale> findAllByCity = saveDailySaleRepo.findAllByDistrictNameAndDate(districtName, localDate);
        List<SaveDailySale> returnDistrictList = new ArrayList<>();
        getBySaveDailySale(type, packagingType, findAllByCity, returnDistrictList);
        return returnDistrictList;
    }

    @Override
    public List findByShopName(String shopName, LocalDate date, String type, String packagingType) {
        List<SaveDailySale> findAllByShop = saveDailySaleRepo.findAllByShopNameAndDate(shopName, date);
        List<SaveDailySale> returnShopList = new ArrayList<>();
        getBySaveDailySale(type, packagingType, findAllByShop, returnShopList);
        return returnShopList;
    }

    private SaveDailySale getCaseStock2(SaveDailySale sale, MasterBrandNameEntry masterBrandName) {
        List<SaveDailySale> sales = new ArrayList<>();
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

        return sale;
    }

    private void getStock(String packagingType, List<SaveDailySale> returnList, SaveDailySale sale, MasterBrandNameEntry masterBrandName) {
        if (packagingType.equalsIgnoreCase("C")) {
            returnList.add(getCaseStock2(sale, masterBrandName));
        } else if ((packagingType.equalsIgnoreCase("B"))) {
            System.out.println("inside B");
            returnList.add(sale);
        }
    }


    private void getBySaveDailySale(String type, String packagingType, List<SaveDailySale> findAllByCity, List<SaveDailySale> returnList) {
        for (SaveDailySale sale : findAllByCity) {
            MasterBrandNameEntry masterBrandName = (masterBrandEntryRepo.findByBrandName(sale.getBrandName()));

            String brandName = sale.getBrandName();
            String shopName = sale.getShopName();
            AddingParcha selectBrandType = parchaRepo.findByBrandNameAndShopName(brandName, shopName);

            if (selectBrandType.getBrandType().equals(BrandType.ENGLISH) && type.equalsIgnoreCase("E")) {
                getStock(packagingType, returnList, sale, masterBrandName);
            } else if (selectBrandType.getBrandType().equals(BrandType.DESI) && type.equalsIgnoreCase("D")) {
                getStock(packagingType, returnList, sale, masterBrandName);
            } else if (selectBrandType.getBrandType().equals(BrandType.BEER) && type.equalsIgnoreCase("D")) {
                getStock(packagingType, returnList, sale, masterBrandName);
            } else if (type.equalsIgnoreCase("A")) {
                getStock(packagingType, returnList, sale, masterBrandName);
            }

        }
    }


}
