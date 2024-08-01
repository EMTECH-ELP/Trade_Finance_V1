package com.TradeFinance.bankguarantee.repository;


import com.TradeFinance.bankguarantee.utils.enums.TransactionStatus;
import com.TradeFinance.bankguarantee.entity.BankGuarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankGuaranteeRepository extends JpaRepository<BankGuarantee, Long> {
    Optional<BankGuarantee> findById(Long id);

    Optional<BankGuarantee> findByGuaranteeNo(String guaranteeNo);
    List<BankGuarantee> findByStatus(TransactionStatus transactionStatus);
}
