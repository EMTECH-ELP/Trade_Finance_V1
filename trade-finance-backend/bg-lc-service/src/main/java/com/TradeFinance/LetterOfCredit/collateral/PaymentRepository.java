package com.TradeFinance.LetterOfCredit.collateral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentSecurity,Long> {
}
