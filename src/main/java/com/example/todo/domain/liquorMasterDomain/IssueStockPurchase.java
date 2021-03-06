package com.example.todo.domain.liquorMasterDomain;

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
@EqualsAndHashCode(exclude = {"issueStock"})
public class IssueStockPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private int quarts;
    private int pints;
    private int nips;


    @JsonIgnore
    @ManyToOne
    private IssueStock issueStock;

    public IssueStockPurchase(String brandName, int quarts, int pints, int nips, IssueStock issueStock) {
        this.brandName = brandName;
        this.quarts = quarts;
        this.pints = pints;
        this.nips = nips;
        this.issueStock = issueStock;
    }

}
