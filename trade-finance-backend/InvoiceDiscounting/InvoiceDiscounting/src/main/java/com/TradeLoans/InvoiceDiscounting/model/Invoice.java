package com.TradeLoans.InvoiceDiscounting.model;


import com.TradeLoans.InvoiceDiscounting.utils.InvoiceNumberGenerator;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String invoiceNumber;
    private Date invoiceDate;
    private BigDecimal invoiceAmount;
    private Date dueDate;
    private String applicantBusinessAddress;
    private String applicantBusinessName;
    private String termsAndCondition;
    private String buyerName;
    private String buyerBusinessName;
    private String buyerCity;
    private String buyerCountry;
    private String buyerEmailAddress;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    //Generate invoiceNumber field automatically
    @PrePersist
    public void generateInvoiceNumber() {
        if (this.invoiceNumber == null || this.invoiceNumber.isEmpty()) {
            this.invoiceNumber = InvoiceNumberGenerator.generate();
        }
    }

    // Automatically transition invoice status from CREATED to PENDING when created
    @PostPersist
    public void transitionToPending() {
        this.setStatus(InvoiceStatus.PENDING);
    }

}


