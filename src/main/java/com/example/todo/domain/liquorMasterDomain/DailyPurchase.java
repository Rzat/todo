package com.example.todo.domain.liquorMasterDomain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
//@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DailyPurchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String purchaseCode;
    private String purchaseFrom;
    private String purchaseTo;
    private Date date;
    private Size size;
    /* private String brandName;
     private int quarts;
     private int pints;
     private int nips;
 */
    @OneToMany(mappedBy = "dailyPurchase", cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();


    public DailyPurchase addOrders2(List<Orders> orders) {
        for (Orders order : orders) {
            order.setDailyPurchase(this);
        }
        this.orders = orders;
        return this;
    }

}
