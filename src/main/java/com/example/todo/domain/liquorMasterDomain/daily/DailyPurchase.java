package com.example.todo.domain.liquorMasterDomain.daily;

import com.example.todo.domain.liquorMasterDomain.Orders;
import com.example.todo.domain.liquorMasterDomain.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
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
