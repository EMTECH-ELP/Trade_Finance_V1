package com.TradeFinance.bankguarantee.repository;

import com.TradeFinance.bankguarantee.entity.BGApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<BGApplicant, Long> {
}
