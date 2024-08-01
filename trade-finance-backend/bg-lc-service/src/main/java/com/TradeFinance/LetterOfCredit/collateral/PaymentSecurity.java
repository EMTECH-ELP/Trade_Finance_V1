package com.TradeFinance.LetterOfCredit.collateral;

import com.TradeFinance.LetterOfCredit.LetterOfCredit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "payment_security_tbl")
public class PaymentSecurity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double collateralValue;
    private String collateralType;
    private String guarantorName;
    private String guarantorAddress;
    private String guarantorEmail;
    private String guarantorPhoneNumber;
    @OneToOne(mappedBy = "paymentSecurity")
    @JsonBackReference
    private LetterOfCredit letterOfCredit;
}
