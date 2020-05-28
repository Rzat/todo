package com.example.todo.domain.liquorMasterDomain;


import com.example.todo.domain.liquorMasterDomain.daily.DailyPurchase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@EqualsAndHashCode(exclude = {"dailyPurchase"})
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private int quarts;
    private int pints;
    private int nips;


    @JsonIgnore
    @ManyToOne
    private DailyPurchase dailyPurchase;

    public Orders(String brandName, int quarts, int pints, int nips, DailyPurchase dailyPurchase) {
        this.brandName = brandName;
        this.quarts = quarts;
        this.pints = pints;
        this.nips = nips;
        this.dailyPurchase = dailyPurchase;
    }


}
