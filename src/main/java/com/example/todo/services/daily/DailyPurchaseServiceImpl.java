package com.example.todo.services.daily;

import com.example.todo.controller.liquorShop.NotFoundException;
import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.Orders;
import com.example.todo.domain.liquorMasterDomain.daily.DailyPurchase;
import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.DailyPurchaseRpo;
import com.example.todo.repositories.daily.DailySaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPurchaseServiceImpl implements DailyPurchaseService {

    private final AddingParchaRepo addingParchaRepo;
    private final DailyPurchaseRpo dailyPurchaseRpo;
    private final DailySaleRepo dailySaleRepo;


    @Override
    public List<DailyPurchase> findAll() {
        return dailyPurchaseRpo.findAll();
    }

    @Transactional
    @Override
    public void newSaveDailyPurchase(DailyPurchase purchase) {

        DailyPurchase dailyPurchase = new DailyPurchase();
        dailyPurchase.setSize(purchase.getSize());
        dailyPurchase.setPurchaseFrom(purchase.getPurchaseFrom());
        dailyPurchase.setPurchaseTo(purchase.getPurchaseTo());
        dailyPurchase.setDate(purchase.getDate());
        dailyPurchase.addOrders2(purchase.getOrders());

        //loop for multiple orders
        addingLoop(purchase);
        dailyPurchaseRpo.save(dailyPurchase);

//Setting Daily Sale Opening column
        for (Orders orders : purchase.getOrders()) {
            System.out.println(dailySaleRepo.findByShopNameAndBrandName(purchase.getPurchaseTo(), orders.getBrandName()));
            DailySale sale = dailySaleRepo.findByShopNameAndBrandName(purchase.getPurchaseTo(), orders.getBrandName());
            sale.setOpeningQuarts(orders.getQuarts());
            sale.setOpeningPints(orders.getPints());
            sale.setOpeningNips(orders.getNips());
            dailySaleRepo.save(sale);
        }


    }

    private void addingLoop(DailyPurchase purchase) {
        String purchaseFrom = purchase.getPurchaseFrom();
        String purchaseTo = purchase.getPurchaseTo();
        for (Orders orders : purchase.getOrders()) {
            AddingParcha parchaFrom = addingParchaRepo.findByShopNameAndBrandName(purchaseFrom, orders.getBrandName())
                    .orElseThrow(() -> new NotFoundException("Adding Parcha from  Not Found"));
            AddingParcha parchaTo = addingParchaRepo.findByShopNameAndBrandName(purchaseTo, orders.getBrandName())
                    .orElseThrow((() -> new NotFoundException("Adding Parcha To Not Found")));

            if (parchaFrom.getBrandName().equals(orders.getBrandName()) &&
                    parchaTo.getBrandName().equals(orders.getBrandName())) {
                updateParcha2(parchaFrom, orders, parchaTo);
            } else {
                // TODO: 5/19/2020 handle exception gracefully
                System.out.println("BrandnameNot found" + orders.getBrandName());
            }
        }
    }

    private void updateParcha2(AddingParcha parcha, Orders purchase, AddingParcha parchaTo) {
        Optional<AddingParcha> optionalAddingParcha = Optional.of(parcha);
        Optional<AddingParcha> optionalAddingParchaTO = Optional.of(parchaTo);

        AddingParcha addingParcha = optionalAddingParcha.get();
        AddingParcha addingParchaTo = optionalAddingParchaTO.get();
        if (purchase.getNips() != 0) {
            //Adding Purchase From
            int nips = addingParcha.getNips();
            int purchaseNips = purchase.getNips();
            int nipsToBeSet = nips - purchaseNips;
            addingParcha.setNips(nipsToBeSet);
            //Adding PurchaseTo
            int nipsTO = addingParchaTo.getNips();
            int purchaseNipsTo = purchase.getNips();
            int nipsToBeSetTo = nipsTO + purchaseNipsTo;
            addingParchaTo.setNips((nipsToBeSetTo));
            System.out.println("Inside nips");
        }

        if (purchase.getPints() != 0) {
            //Adding Purchase From
            int pints = addingParcha.getPints();
            int purchasePints = purchase.getPints();
            int pintsToBeSet = pints - purchasePints;
            addingParcha.setPints(pintsToBeSet);
            //Adding PurchaseTo
            int pintsTO = addingParchaTo.getPints();
            int purchasepintsTo = purchase.getPints();
            int pintsToBeSetTo = pintsTO + purchasepintsTo;
            addingParchaTo.setPints((pintsToBeSetTo));
            System.out.println("Inside Pints");
        }
        if (purchase.getQuarts() != 0) {
            //Adding Purchase From
            int quarts = addingParcha.getQuarts();
            int purchaseQuarts = purchase.getQuarts();
            int quartsToBeSet = quarts - purchaseQuarts;
            addingParcha.setQuarts(quartsToBeSet);
            //Adding PurchaseTo
            int quartsTO = addingParchaTo.getQuarts();
            int purchaseQuartsTo = purchase.getQuarts();
            int quartsToBeSetTo = quartsTO + purchaseQuartsTo;
            addingParchaTo.setQuarts((quartsToBeSetTo));
            System.out.println("Inside Quarts");
        }
        addingParchaRepo.save(addingParcha);
        addingParchaRepo.save(addingParchaTo);
    }
}
