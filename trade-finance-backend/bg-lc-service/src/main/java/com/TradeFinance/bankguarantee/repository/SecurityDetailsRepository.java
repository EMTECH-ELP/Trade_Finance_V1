package com.TradeFinance.bankguarantee.repository;

import com.TradeFinance.bankguarantee.entity.SecurityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityDetailsRepository extends JpaRepository<SecurityDetails, Long> {
}
