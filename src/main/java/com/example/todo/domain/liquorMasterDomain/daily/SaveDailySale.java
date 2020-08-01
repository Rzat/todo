package com.example.todo.domain.liquorMasterDomain.daily;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class SaveDailySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shopName;

    private int openingQuarts;
    private int openingPints;
    private int openingNips;

    private int transferQuarts;
    private int transferPints;
    private int transferNips;

    private int receiptQuarts;
    private int receiptPints;
    private int receiptNips;

    private int saleQuarts;
    private int salePints;
    private int saleNips;

    private int rateQuarts;
    private int ratePints;
    private int rateNips;

    private int amountQuarts;
    private int amountPints;
    private int amountNips;

    private double closingQuarts;
    private double closingPints;
    private double closingNips;

    private String brandName;
    private LocalDate date;

}
