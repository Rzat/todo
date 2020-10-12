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
    private final String identifier = "Stock_Position";
    // private final SaleReportServiceImpl saleReportService;

    DecimalFormat df = new DecimalFormat("#.###");


    @Override
    public List findStockByCity(String cityName, LocalDate localDate, String type, String packagingType) {
        List<SaveDailySale> findAllByCity = saveDailySaleRepo.findAllByCityNameAndDate(cityName, localDate);
        List<SaveDailySale> returnList = new ArrayList<>();
        getBySaveDailySale(type, packagingType, findAllByCity, returnList, this.identifier);
        return returnList;
    }

    @Override
    public List findByDistrict(String districtName, LocalDate localDate, String type, String packagingType) {
        List<SaveDailySale> findAllByCity = saveDailySaleRepo.findAllByDistrictNameAndDate(districtName, localDate);
        List<SaveDailySale> returnDistrictList = new ArrayList<>();
        getBySaveDailySale(type, packagingType, findAllByCity, returnDistrictList, this.identifier);
        return returnDistrictList;
    }

    @Override
    public List findByShopName(String shopName, LocalDate date, String type, String packagingType) {
        List<SaveDailySale> findAllByShop = saveDailySaleRepo.findAllByShopNameAndDate(shopName, date);
        List<SaveDailySale> returnShopList = new ArrayList<>();
        getBySaveDailySale(type, packagingType, findAllByShop, returnShopList, this.identifier);
        return returnShopList;
    }

    private SaveDailySale getCaseStock2(SaveDailySale sale, MasterBrandNameEntry masterBrandName, String identifier) {
        List<SaveDailySale> sales = new ArrayList<>();
        int packing1 = masterBrandName.getPacking1();
        int packing2 = masterBrandName.getPacking2();
        int packing3 = masterBrandName.getPacking3();


        if (identifier.equalsIgnoreCase(this.identifier)) {
            double qCB = sale.getClosingQuarts();
            double pCB = sale.getClosingPints();
            double nCB = sale.getClosingNips();

            double setQuartsCB = (qCB) / packing1;
            double setPintsCB = (pCB) / packing2;
            double setNipsCB = (nCB) / packing3;

            sale.setClosingQuarts(Double.parseDouble(df.format(setQuartsCB)));
            sale.setClosingPints(Double.parseDouble(df.format(setPintsCB)));
            sale.setClosingNips(Double.parseDouble(df.format(setNipsCB)));
        } else if (identifier.equalsIgnoreCase("Sales_Report")) {
            double qCBSale = sale.getSaleQuarts();
            double pCBSale = sale.getSalePints();
            double nCBSale = sale.getSaleNips();

            double setQuartsSale = (qCBSale) / packing1;
            double setPintsSale = (pCBSale) / packing2;
            double setNipsSale = (nCBSale) / packing3;

            sale.setClosingQuarts(Double.parseDouble(df.format(setQuartsSale)));
            sale.setClosingPints(Double.parseDouble(df.format(setPintsSale)));
            sale.setClosingNips(Double.parseDouble(df.format(setNipsSale)));
        }


        return sale;
    }

    private void getStock(String packagingType, List<SaveDailySale> returnList, SaveDailySale sale, MasterBrandNameEntry masterBrandName, String identifier) {
        if (packagingType.equalsIgnoreCase("C")) {
            returnList.add(getCaseStock2(sale, masterBrandName, identifier));
        } else if ((packagingType.equalsIgnoreCase("B"))) {
            System.out.println("inside B");
            returnList.add(sale);
        }
    }


    public void getBySaveDailySale(String type, String packagingType, List<SaveDailySale> findAllByCity, List<SaveDailySale> returnList, String identifier) {
        for (SaveDailySale sale : findAllByCity) {
            MasterBrandNameEntry masterBrandName = (masterBrandEntryRepo.findByBrandName(sale.getBrandName()));

            String brandName = sale.getBrandName();
            String shopName = sale.getShopName();
            AddingParcha selectBrandType = parchaRepo.findByBrandNameAndShopName(brandName, shopName);

            if (selectBrandType.getBrandType().equals(BrandType.ENGLISH) && type.equalsIgnoreCase("E")) {
                getStock(packagingType, returnList, sale, masterBrandName, identifier);
            } else if (selectBrandType.getBrandType().equals(BrandType.DESI) && type.equalsIgnoreCase("D")) {
                getStock(packagingType, returnList, sale, masterBrandName, identifier);
            } else if (selectBrandType.getBrandType().equals(BrandType.BEER) && type.equalsIgnoreCase("D")) {
                getStock(packagingType, returnList, sale, masterBrandName, identifier);
            } else if (type.equalsIgnoreCase("A")) {
                getStock(packagingType, returnList, sale, masterBrandName, identifier);
            }

        }
    }


}
