package com.TradeFinance.bankguarantee.repository;


import com.TradeFinance.bankguarantee.entity.ShipmentTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentTermsRepository extends JpaRepository<ShipmentTerms,Long> {
}
