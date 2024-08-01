package com.TradeFinance.bankguarantee.repository;

import com.TradeFinance.bankguarantee.entity.BGShipmentAndGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentAndGoodsRepositoryBG extends JpaRepository<BGShipmentAndGoods,Long> {
}
