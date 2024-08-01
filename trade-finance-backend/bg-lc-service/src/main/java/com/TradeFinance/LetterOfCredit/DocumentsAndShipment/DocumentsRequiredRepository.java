package com.TradeFinance.LetterOfCredit.DocumentsAndShipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRequiredRepository extends JpaRepository<DocumentsRequired,Long> {
}
