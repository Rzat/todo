package com.example.todo.domain.liquorMasterDomain.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class StockPosition {
    private Date dateupto;
    private String selectShop;
    private String cityName;
    private String groupName;
    private String district;
    private String type;
    private String bottleCase;

}
