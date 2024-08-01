package com.TradeFinance.bankguarantee.controller;

import com.TradeFinance.bankguarantee.entity.ShipmentTerms;
import com.TradeFinance.bankguarantee.service.ShipmentTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/shipment_terms")
public class ShipmentTermsController {

    @Autowired
    private ShipmentTermsService shipmentTermsService;

    @GetMapping
    public ResponseEntity<List<ShipmentTerms>> getAllShipmentTerms() {
        List<ShipmentTerms> securityDetails = shipmentTermsService.getAllShipmentTerms();
        return new ResponseEntity<>(securityDetails, HttpStatus.OK);
    }

    @GetMapping("/{shipmentTermId}")
    public ResponseEntity<ShipmentTerms> getShipmentTermById(@PathVariable Long shipmentTermId) {
        Optional<ShipmentTerms> shipmentTerm = shipmentTermsService.getShipmentTermById(shipmentTermId);
        return shipmentTerm.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ShipmentTerms> createShipmentTerm(@RequestBody ShipmentTerms shipmentTerm) {
        ShipmentTerms savedSecurityDetail = shipmentTermsService.saveShipmentTerm(shipmentTerm);
        return new ResponseEntity<>(savedSecurityDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{shipmentTermId}")
    public ResponseEntity<Void> deleteShipmentTerm(@PathVariable Long shipmentTermId) {
        shipmentTermsService.deleteShipmentTerm(shipmentTermId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
