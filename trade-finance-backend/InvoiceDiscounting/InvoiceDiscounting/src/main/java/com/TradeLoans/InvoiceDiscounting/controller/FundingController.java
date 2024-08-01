package com.TradeLoans.InvoiceDiscounting.controller;

import com.TradeLoans.InvoiceDiscounting.dtos.FundingDTO;
import com.TradeLoans.InvoiceDiscounting.dtos.FundingDetailsDTO;
import com.TradeLoans.InvoiceDiscounting.service.FundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@RestController
@RequestMapping("/api/fundings")
@CrossOrigin("*")
public class FundingController {

@Autowired
private FundingService fundingService;

@PostMapping("/calculate")
public ResponseEntity<FundingDTO> calculateFundingAmount(@RequestParam String invoiceNumber,
                                                         @RequestParam BigDecimal discountRate,
                                                         @RequestParam BigDecimal creditLimit) {
    FundingDTO fundingDTO = fundingService.calculateFundingAmount(invoiceNumber, discountRate, creditLimit);
    return ResponseEntity.ok(fundingDTO);
}

@PostMapping
public ResponseEntity<FundingDTO> createFunding(@RequestBody FundingDTO fundingDTO,
                                                @RequestParam String invoiceNumber) {
    FundingDTO createdFunding = fundingService.createFunding(fundingDTO, invoiceNumber);
    return ResponseEntity.ok(createdFunding);
}

@PutMapping("/{id}")
public ResponseEntity<FundingDTO> updateFunding(@PathVariable Long id,
                                                @RequestBody FundingDTO fundingDTO) {
    FundingDTO updatedFunding = fundingService.updateFunding(id, fundingDTO);
    return ResponseEntity.ok(updatedFunding);
}

@PutMapping("/approve/{id}")
public ResponseEntity<FundingDTO> approveFunding(@PathVariable Long id) {
    FundingDTO approvedFunding = fundingService.approveFunding(id);
    return ResponseEntity.ok(approvedFunding);
}

@PutMapping("/approve-by-invoice-number")
public ResponseEntity<FundingDTO> approveFundingByInvoiceNumber(@RequestParam String invoiceNumber) {
    FundingDTO approvedFunding = fundingService.approveFundingByInvoiceNumber(invoiceNumber);
    return ResponseEntity.ok(approvedFunding);
}

@GetMapping("/{id}")
public ResponseEntity<FundingDTO> getFunding(@PathVariable Long id) {
    return fundingService.getFunding(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@GetMapping("/by-invoice-number")
public ResponseEntity<FundingDTO> getFundingByInvoiceNumber(@RequestParam String invoiceNumber) {
    return fundingService.getFundingByInvoiceNumber(invoiceNumber)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteFunding(@PathVariable Long id) {
    fundingService.deleteFunding(id);
    return ResponseEntity.noContent().build();
}

@GetMapping
public ResponseEntity<List<FundingDTO>> getAllFundings() {
    List<FundingDTO> fundings = fundingService.getAllFundings();
    return ResponseEntity.ok(fundings);
}

@GetMapping("/details-by-invoice-number")
public ResponseEntity<FundingDetailsDTO> getFundingDetailsByInvoiceNumber(@RequestParam String invoiceNumber) {
    FundingDetailsDTO details = fundingService.getFundingDetailsByInvoiceNumber(invoiceNumber);
    return ResponseEntity.ok(details);
}
}