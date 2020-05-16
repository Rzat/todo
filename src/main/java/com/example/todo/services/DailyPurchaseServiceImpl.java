package com.example.todo.services;

import com.example.todo.controller.liquorShop.NotFoundException;
import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.DailyPurchase;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.DailyPurchaseRpo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyPurchaseServiceImpl implements DailyPurchaseService {

    private final AddingParchaRepo addingParchaRepo;
    private final DailyPurchaseRpo dailyPurchaseRpo;

    @Override
    public void saveDailyPurchase(DailyPurchase purchase) {
        /*System.out.println(purchase);
        System.out.println(purchase.getNips());*/
        String purchaseFrom = purchase.getPurchaseFrom();
        AddingParcha parch = addingParchaRepo.findByShopName(purchaseFrom).orElseThrow(NotFoundException::new);

        //addingParchaRepo.getOne(parch.getId());
        updateParcha(parch, purchase);
    }

    private void updateParcha(AddingParcha parcha, DailyPurchase purchase) {
        Optional<AddingParcha> optionalAddingParcha = Optional.of(parcha);

        if (optionalAddingParcha.isPresent()) {
            AddingParcha addingParcha = optionalAddingParcha.get();
            if (purchase.getNips() != 0) {
                int nips = addingParcha.getNips();
                int purchaseNips = purchase.getNips();
                int nipsToBeSet = nips - purchaseNips;
                addingParcha.setNips(nipsToBeSet);
                //  addingParchaRepo.save(addingParcha);
                System.out.println("Inside nips");
            }

            if (purchase.getPints() != 0) {
                System.out.println("Inside Pints");
                // AddingParcha addingParcha = optionalAddingParcha.get();
                int pints = addingParcha.getPints();
                int purchasePints = purchase.getPints();
                int pintsToBeSet = pints - purchasePints;
                addingParcha.setPints(pintsToBeSet);
                //addingParchaRepo.save(addingParcha);
                System.out.println("Inside Pints");
            }
            if (purchase.getQuarts() != 0) {
                // AddingParcha addingParcha = optionalAddingParcha.get();
                int quarts = addingParcha.getQuarts();
                int purchaseQuarts = purchase.getQuarts();
                int quartsToBeSet = quarts - purchaseQuarts;
                addingParcha.setQuarts(quartsToBeSet);
                // addingParchaRepo.save(addingParcha);
                System.out.println("Inside Quarts");
            }
            addingParchaRepo.save(addingParcha);
            dailyPurchaseRpo.save(purchase);
            /*Optional<DailyPurchase> purchaseToBeSaved = Optional.of(purchase);
            DailyPurchase dailyPurchase = purchaseToBeSaved.get();
            dailyPurchase.setBrandName(purchase.getBrandName());
            dailyPurchase.setDate(purchase.getDate());
            dailyPurchase.setNips(purchase.getNips());
            dailyPurchase.setPints(purchase.getPints());
            dailyPurchase*/


        }
    }
}
