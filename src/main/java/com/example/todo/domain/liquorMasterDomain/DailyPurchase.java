package com.example.todo.domain.liquorMasterDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class DailyPurchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String purchaseCode;
    private String purchaseFrom;
    private String purchaseTo;
    private Date date;
    private Size size;
    private String brandName;
    private int quarts;
    private int pints;
    private int nips;


}
