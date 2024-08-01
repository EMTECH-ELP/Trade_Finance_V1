package com.TradeLoans.InvoiceDiscounting.repository;

import com.TradeLoans.InvoiceDiscounting.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findByNameContainingIgnoreCase(String name);
}
