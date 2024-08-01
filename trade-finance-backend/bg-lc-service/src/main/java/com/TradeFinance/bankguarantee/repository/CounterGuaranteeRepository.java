package com.TradeFinance.bankguarantee.repository;

import com.TradeFinance.bankguarantee.entity.CounterGuaranteeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterGuaranteeRepository extends JpaRepository<CounterGuaranteeDetails, Long> {
}
