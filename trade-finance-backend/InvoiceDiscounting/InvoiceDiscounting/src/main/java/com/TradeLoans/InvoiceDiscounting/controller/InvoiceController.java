package com.TradeLoans.InvoiceDiscounting.controller;
// Endpoint: http://192.168.90.44:9000/invoices/create (Ip keep changing)192.168.90.44

import com.TradeLoans.InvoiceDiscounting.dtos.InvoiceDTO;
import com.TradeLoans.InvoiceDiscounting.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/invoices")
@CrossOrigin("*")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> createInvoice(@RequestParam Long applicantId, @RequestBody InvoiceDTO invoiceDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.createInvoice(applicantId, invoiceDTO));
    }


    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAllInvoices() {
        List<InvoiceDTO> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDTO> updateInvoice(@PathVariable Long id, @RequestBody @Valid InvoiceDTO invoiceDTO) {
        InvoiceDTO updatedInvoice = invoiceService.updateInvoice(id, invoiceDTO);
        return ResponseEntity.ok(updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<InvoiceDTO> approveInvoice(@PathVariable Long id) {
        InvoiceDTO approvedInvoice = invoiceService.approveInvoiceById(id);
        return ResponseEntity.ok(approvedInvoice);
    }

    @PutMapping("/approve/{invoiceNumber}")
    public ResponseEntity<InvoiceDTO> approveInvoiceByInvoiceNumber(@PathVariable String invoiceNumber) {
        InvoiceDTO approvedInvoice = invoiceService.approveInvoiceByInvoiceNumber(invoiceNumber);
        return ResponseEntity.ok(approvedInvoice);
    }
    // Other endpoints as needed

    @DeleteMapping("/delete")
    public void deleteInvoiceByInvoiceNumber(@RequestParam String invoiceNumber) {
        invoiceService.deleteInvoiceByInvoiceNumber(invoiceNumber);
    }

    @PutMapping("/modify")
    public InvoiceDTO modifyInvoiceByInvoiceNumber(@RequestParam String invoiceNumber, @RequestBody InvoiceDTO invoiceDTO) {
        return invoiceService.modifyInvoiceByInvoiceNumber(invoiceNumber, invoiceDTO);
    }


}
