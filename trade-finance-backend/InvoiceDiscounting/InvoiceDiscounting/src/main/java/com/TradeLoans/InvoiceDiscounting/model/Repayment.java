package com.TradeLoans.InvoiceDiscounting.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "repayments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Repayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repaymentId;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Column(name = "debtor_name_id")
    private Long debtorNameId;

    @Column(name = "original_amount")
    private BigDecimal originalAmount;

    @Column(name = "repayment_amount")
    private BigDecimal repaymentAmount;

    @Column(name = "outstanding_amount")
    private BigDecimal outstandingAmount;

    @Column(name = "repayment_date")
    private Date repaymentDate;

    @Column(name = "actual_repayment_date")
    private Date actualRepaymentDate;

    @Enumerated(EnumType.STRING)
    private RepaymentStatus status;

    @Column(name = "penalty_amount")
    private BigDecimal penaltyAmount;

    public enum RepaymentStatus {
        PENDING, PAID, OVERDUE
    }

    public void calculateOutstandingAmount() {
        this.outstandingAmount = this.originalAmount.subtract(this.repaymentAmount);
    }

    public void updateStatus() {
        if (this.actualRepaymentDate != null) {
            this.status = RepaymentStatus.PAID;
        } else if (this.repaymentDate.before(new Date())) {
            this.status = RepaymentStatus.OVERDUE;
        } else {
            this.status = RepaymentStatus.PENDING;
        }
    }

    public void applyPenalty(BigDecimal penaltyRate) {
        if (this.status == RepaymentStatus.OVERDUE) {
            this.penaltyAmount = this.outstandingAmount.multiply(penaltyRate);
        } else {
            this.penaltyAmount = BigDecimal.ZERO;
        }
    }

    public void recordRepayment(BigDecimal amount, Date date) {
        this.repaymentAmount = amount;
        this.actualRepaymentDate = date;
        calculateOutstandingAmount();
        updateStatus();
    }

    public void scheduleNotification() {
        // Logic to schedule notifications
    }

    public String getRepaymentHistory() {
        // Logic to retrieve repayment history
        return "Repayment history for invoice: " + this.invoice.getInvoiceNumber();
    }
}