package com.TradeLoans.InvoiceDiscounting.repository;

import com.TradeLoans.InvoiceDiscounting.model.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {

}
