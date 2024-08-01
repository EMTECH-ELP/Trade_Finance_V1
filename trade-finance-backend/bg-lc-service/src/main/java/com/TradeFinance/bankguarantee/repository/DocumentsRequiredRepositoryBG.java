package com.TradeFinance.bankguarantee.repository;

import com.TradeFinance.bankguarantee.entity.BGDocumentsRequired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRequiredRepositoryBG extends JpaRepository<BGDocumentsRequired,Long> {
}
