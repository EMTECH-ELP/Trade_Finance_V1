package com.TradeFinance.bankguarantee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ShipmentTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentTermId;

    private String termCode;
    private String termDescription;
}
