package com.TradeFinance.collectionservice.goodsAndShipment;

import com.TradeFinance.collectionservice.collection.Collection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal value;
    private int quantity;
    private String hsCode;
    @OneToOne(mappedBy="good")
    private Collection collection;
}
