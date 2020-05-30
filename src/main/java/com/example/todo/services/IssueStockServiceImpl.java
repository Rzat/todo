package com.example.todo.services;

import com.example.todo.controller.liquorShop.NotFoundException;
import com.example.todo.domain.liquorMasterDomain.AddingParcha;
import com.example.todo.domain.liquorMasterDomain.IssueStock;
import com.example.todo.domain.liquorMasterDomain.IssueStockPurchase;
import com.example.todo.domain.liquorMasterDomain.daily.DailySale;
import com.example.todo.repositories.AddingParchaRepo;
import com.example.todo.repositories.IssueStockRepo;
import com.example.todo.repositories.daily.DailySaleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IssueStockServiceImpl implements IssueStockService {

    private final AddingParchaRepo addingParchaRepo;
    private final IssueStockRepo stockRepo;
    private final DailySaleRepo dailySaleRepo;

    @Override
    @Transactional
    public void saveStock(IssueStock stock) {
       /* GeneralDAO<IssueStock> issueStockGeneralDAO = new GeneralDAO<IssueStock>();
        issueStockGeneralDAO.save(stock);*/
        IssueStock issueStock = new IssueStock();
        issueStock.setSize(stock.getSize());
        issueStock.setIssueFrom(stock.getIssueFrom());
        issueStock.setIssueTo(stock.getIssueTo());
        issueStock.setDate(stock.getDate());
        issueStock.addOrders2(stock.getOrders());

        addingMultipleOrder(stock);
        stockRepo.save(issueStock);

        // Setting Daily sale Transfer column
        for (IssueStockPurchase stockPurchase : stock.getOrders()) {
            DailySale saleTransfer = dailySaleRepo.findByShopNameAndBrandName(stock.getIssueFrom(), stockPurchase.getBrandName());
            saleTransfer.setTransferQuarts(stockPurchase.getQuarts());
            saleTransfer.setTransferPints(stockPurchase.getPints());
            saleTransfer.setTransferNips(stockPurchase.getNips());
            dailySaleRepo.save(saleTransfer);
        }
        System.out.println("saved");
    }

    private void addingMultipleOrder(IssueStock stock) {
        String issueFrom = stock.getIssueFrom();
        String issueTo = stock.getIssueTo();
        for (IssueStockPurchase stockPurchase : stock.getOrders()) {

            // TODO: 5/30/2020 make this method common for IssueStock and Daily Purchase
            AddingParcha issueParchaFrom = addingParchaRepo.findByShopNameAndBrandName(issueFrom, stockPurchase.getBrandName())
                    .orElseThrow(() -> new NotFoundException("Adding Parcha From not found while Issuing From"));

            AddingParcha issueParchaTo = addingParchaRepo.findByShopNameAndBrandName(issueTo, stockPurchase.getBrandName())
                    .orElseThrow((() -> new NotFoundException("Adding Parcha To Not Found")));

            updateAddingParch(issueParchaFrom, stockPurchase, issueParchaTo);

        }
    }

    private void updateAddingParch(AddingParcha issueParchaFrom, IssueStockPurchase stockPurchase, AddingParcha issueParchaTo) {
        // TODO: 5/30/2020  remove duplicate code try to use generics
        Optional<AddingParcha> optionalissueParchaFrom = Optional.of(issueParchaFrom);
        Optional<AddingParcha> optionalissueParchaTo = Optional.of(issueParchaTo);

        AddingParcha addingParcha = optionalissueParchaFrom.get();
        AddingParcha addingParchaTo = optionalissueParchaTo.get();

        if (stockPurchase.getNips() != 0) {
            //Adding Purchase From
            int nips = addingParcha.getNips();
            int purchaseNips = stockPurchase.getNips();
            int nipsToBeSet = nips - purchaseNips;
            addingParcha.setNips(nipsToBeSet);
            //Adding PurchaseTo
            int nipsTO = addingParchaTo.getNips();
            int purchaseNipsTo = stockPurchase.getNips();
            int nipsToBeSetTo = nipsTO + purchaseNipsTo;
            addingParchaTo.setNips((nipsToBeSetTo));
            System.out.println("Inside nips");
        }

        if (stockPurchase.getPints() != 0) {
            //Adding Purchase From
            int pints = addingParcha.getPints();
            int purchasePints = stockPurchase.getPints();
            int pintsToBeSet = pints - purchasePints;
            addingParcha.setPints(pintsToBeSet);
            //Adding PurchaseTo
            int pintsTO = addingParchaTo.getPints();
            int purchasepintsTo = stockPurchase.getPints();
            int pintsToBeSetTo = pintsTO + purchasepintsTo;
            addingParchaTo.setPints((pintsToBeSetTo));
            System.out.println("Inside Pints");
        }
        if (stockPurchase.getQuarts() != 0) {
            //Adding Purchase From
            int quarts = addingParcha.getQuarts();
            int purchaseQuarts = stockPurchase.getQuarts();
            int quartsToBeSet = quarts - purchaseQuarts;
            addingParcha.setQuarts(quartsToBeSet);
            //Adding PurchaseTo
            int quartsTO = addingParchaTo.getQuarts();
            int purchaseQuartsTo = stockPurchase.getQuarts();
            int quartsToBeSetTo = quartsTO + purchaseQuartsTo;
            addingParchaTo.setQuarts((quartsToBeSetTo));
            System.out.println("Inside Quarts");
        }
        addingParchaRepo.save(addingParcha);
        addingParchaRepo.save(addingParchaTo);
    }

}
