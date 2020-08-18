package com.example.todo.services.daily;

import com.example.todo.domain.liquorMasterDomain.MasterShopEntry;
import com.example.todo.domain.liquorMasterDomain.daily.SaveDailySale;
import com.example.todo.repositories.MasterShopEntryRepo;
import com.example.todo.repositories.daily.DailySaleRepo;
import com.example.todo.repositories.daily.SaveDailySaleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DailySaleServiceImpl implements DailySaleService {
    private final DailySaleRepo dailySaleRepo;
    private final SaveDailySaleRepo saveDailySaleRepo;
    private final MasterShopEntryRepo masterShopEntryRepo;

    // TODO: 5/31/2020 try to implement log file using slf4j instead of Logger
    private static final Logger logger = Logger.getLogger(DailySaleServiceImpl.class);

    @Override
    public void saveDailySale(List<SaveDailySale> dailySale) {

        for (SaveDailySale sale : dailySale) {
//         logger.error("debugger at work");
            String shopName = sale.getShopName();
            MasterShopEntry shopDetails = masterShopEntryRepo.getByShopName(shopName);
            sale.setCityName(shopDetails.getCity());
            sale.setGroupName(shopDetails.getGroupS());
            sale.setDistrictName(shopDetails.getDistrict());
            saveDailySaleRepo.save(sale);
        }
    }
}
