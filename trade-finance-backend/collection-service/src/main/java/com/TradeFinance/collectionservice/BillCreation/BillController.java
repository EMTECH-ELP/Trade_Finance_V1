package com.TradeFinance.collectionservice.BillCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bills")

public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/{billId}")
    private ResponseEntity<Bill> getBill(@PathVariable Long billId){
        Optional<Bill> bill = billService.getBillById(billId);
        return bill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    private ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        Bill createdBill = billService.createBill(bill);
        return ResponseEntity.ok(createdBill);
    }

    @PostMapping("/{billId}/discount")
    private ResponseEntity<Bill> discountBill(@PathVariable Long billId, @RequestParam double discountAmount){
        Bill discountedBill = billService.discountBill(billId, discountAmount);
        return ResponseEntity.ok(discountedBill);
    }

    @PostMapping("/{billId}/approve")
    public ResponseEntity<String> approveBill(@PathVariable Long billId) {
        try {
            Bill approvedBill = billService.approveBill(billId);
            return ResponseEntity.ok(String.valueOf(approvedBill));
        } catch (IllegalArgumentException e) {
            // If the bill is not found
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            // If the bill has already been approved
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            // For other unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{billId}/avalisation")
    public ResponseEntity<String> requestAvalisation(@PathVariable Long billId, @RequestParam String guarantor, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date expiryDate) {
        try {
            Bill avalisedBill = billService.requestAvalisation(billId, guarantor, expiryDate);
            return ResponseEntity.ok(String.valueOf(avalisedBill));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{billId}/avalisation")
    public ResponseEntity<String> cancelAvalisation(@PathVariable Long billId) {
        try {
            Bill unavalisedBill = billService.cancelAvalisation(billId);
            return ResponseEntity.ok(String.valueOf(unavalisedBill)); // Convert to String
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{billId}")
    private ResponseEntity<Bill> updateBill(@PathVariable Long billId, @RequestBody Bill bill){
        Bill updatedBill = billService.updateBill(billId, bill);
        return ResponseEntity.ok(updatedBill);
    }

    @DeleteMapping("/{billId}")
    private ResponseEntity<Void> deleteBill(@PathVariable Long billId){
        billService.deleteBill(billId);
        return ResponseEntity.noContent().build();
    }
}
