package com.TradeFinance.bankguarantee.service;

import com.TradeFinance.bankguarantee.entity.ShipmentTerms;
import com.TradeFinance.bankguarantee.repository.ShipmentTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentTermsService {

    @Autowired
    private ShipmentTermsRepository shipmentTermsRepository;

    public List<ShipmentTerms> getAllShipmentTerms() {
        return shipmentTermsRepository.findAll();
    }

    public Optional<ShipmentTerms> getShipmentTermById(Long shipmentTermId) {
        return shipmentTermsRepository.findById(shipmentTermId);
    }

    public ShipmentTerms saveShipmentTerm(ShipmentTerms shipmentTerms) {
        return shipmentTermsRepository.save(shipmentTerms);
    }

    public void deleteShipmentTerm(Long shipmentTermId) {
        shipmentTermsRepository.deleteById(shipmentTermId);
    }
}
