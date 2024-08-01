package com.TradeLoans.InvoiceDiscounting.repository;

import com.TradeLoans.InvoiceDiscounting.model.Funding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FundingRepository extends JpaRepository<Funding, Long> {
    Optional<Funding> findByInvoiceInvoiceNumber(String invoiceNumber);
}
