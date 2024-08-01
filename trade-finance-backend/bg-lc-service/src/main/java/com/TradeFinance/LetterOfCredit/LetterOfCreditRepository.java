package com.TradeFinance.LetterOfCredit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LetterOfCreditRepository extends JpaRepository<LetterOfCredit,Long> {
    Optional<LetterOfCredit> findById(Long id);

    Optional<LetterOfCredit> findByLcNumber(String lcNumber);

    List<LetterOfCredit> findByStatus(TransactionStatus transactionStatus);
}
