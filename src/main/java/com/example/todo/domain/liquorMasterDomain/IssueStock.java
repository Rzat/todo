package com.example.todo.domain.liquorMasterDomain;

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
public class IssueStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String purchaseCode;
    private String issueFrom;
    private String issueTo;
    private Date date;
    private Size size;
    @OneToMany(mappedBy = "issueStock", cascade = CascadeType.ALL)
    private List<IssueStockPurchase> orders = new ArrayList<>();


    public IssueStock addOrders2(List<IssueStockPurchase> orders) {
        for (IssueStockPurchase order : orders) {
            order.setIssueStock(this);
        }
        this.orders = orders;
        return this;
    }

}

