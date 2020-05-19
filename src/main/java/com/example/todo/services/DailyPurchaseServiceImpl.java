package com.example.todo.services;

import com.example.todo.controller.liquorShop.NotFoundException;
import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.DailyPurchase;
import com.example.todo.domain.liquorMasterDomain.Orders;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.DailyPurchaseRpo;
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
    private static boolean flag;

    @Override
    public void saveDailyPurchase(DailyPurchase purchase) {
        /*System.out.println(purchase);
        System.out.println(purchase.getNips());*/
        String purchaseFrom = purchase.getPurchaseFrom();
        AddingParcha parch = addingParchaRepo.findByShopName(purchaseFrom).orElseThrow(NotFoundException::new);

        //addingParchaRepo.getOne(parch.getId());
        // updateParcha(parch, purchase);
    }

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
        // dailyPurchase.setOrders(purchase.getOrders());
        dailyPurchase.addOrders2(purchase.getOrders());
       /* Orders order = new Orders();
        order.setDailyPurchase(dailyPurchase);*/
        String purchaseFrom = purchase.getPurchaseFrom();
        String purchaseTo = purchase.getPurchaseTo();
        System.out.println("purchase from" + purchaseFrom);
        System.out.println("purchase To" + purchaseTo);
        AddingParcha parchaFrom = addingParchaRepo.findByShopName(purchaseFrom).orElseThrow(NotFoundException::new);
        AddingParcha parchaTo = addingParchaRepo.findByShopName(purchaseTo).orElseThrow(NotFoundException::new);

        for (Orders orders : purchase.getOrders()) {
            if (parchaFrom.getBrandName().equals(orders.getBrandName()) &&
                    parchaTo.getBrandName().equals(orders.getBrandName())) {
                updateParcha2(parchaFrom, orders, parchaTo);
            } else {
                // TODO: 5/19/2020
                System.out.println("BrandnameNot found" + orders.getBrandName());
            }
        }
        dailyPurchaseRpo.save(dailyPurchase);
    }

    private void updateParcha2(AddingParcha parcha, Orders purchase, AddingParcha parchaTo) {
        Optional<AddingParcha> optionalAddingParcha = Optional.of(parcha);
        Optional<AddingParcha> optionalAddingParchaTO = Optional.of(parchaTo);

        System.out.println("Order Brand Name: " + purchase.getBrandName());


        if (optionalAddingParcha.isPresent() && optionalAddingParchaTO.isPresent()) {
            AddingParcha addingParcha = optionalAddingParcha.get();
            AddingParcha addingParchaTo = optionalAddingParchaTO.get();
            if (purchase.getNips() != 0) {
                /********Adding Purchase From *****/
                int nips = addingParcha.getNips();
                int purchaseNips = purchase.getNips();
                int nipsToBeSet = nips - purchaseNips;
                addingParcha.setNips(nipsToBeSet);
                /*******Adding PurchaseTo*******/
                int nipsTO = addingParchaTo.getNips();
                int purchaseNipsTo = purchase.getNips();
                int nipsToBeSetTo = nipsTO + purchaseNipsTo;
                addingParchaTo.setNips((nipsToBeSetTo));

                System.out.println("Inside nips");
            }

            if (purchase.getPints() != 0) {
                /********Adding Purchase From *****/
                int pints = addingParcha.getPints();
                int purchasePints = purchase.getPints();
                int pintsToBeSet = pints - purchasePints;
                addingParcha.setPints(pintsToBeSet);
                //addingParchaRepo.save(addingParcha);
                /*******Adding PurchaseTo*******/
                int pintsTO = addingParchaTo.getPints();
                int purchasepintsTo = purchase.getPints();
                int pintsToBeSetTo = pintsTO + purchasepintsTo;
                addingParchaTo.setPints((pintsToBeSetTo));
                System.out.println("Inside Pints");
            }
            if (purchase.getQuarts() != 0) {
                /********Adding Purchase From *****/
                int quarts = addingParcha.getQuarts();
                int purchaseQuarts = purchase.getQuarts();
                int quartsToBeSet = quarts - purchaseQuarts;
                addingParcha.setQuarts(quartsToBeSet);
                // addingParchaRepo.save(addingParcha);
                /*******Adding PurchaseTo*******/
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
}
