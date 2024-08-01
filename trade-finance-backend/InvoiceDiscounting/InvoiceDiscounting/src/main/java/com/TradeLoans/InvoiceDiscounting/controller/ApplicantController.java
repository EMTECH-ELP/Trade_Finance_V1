package com.TradeLoans.InvoiceDiscounting.controller;
//http://192.168.89.247:9001/applicants/list

import com.TradeLoans.InvoiceDiscounting.dtos.ApplicantDTO;
import com.TradeLoans.InvoiceDiscounting.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
@CrossOrigin(origins = "*")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping(value = "/invoiceDetails")
    public ResponseEntity<ApplicantDTO> createApplicant(@RequestBody ApplicantDTO applicantDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicantService.createApplicant(applicantDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicantDTO> getApplicant(@PathVariable Long id) {
        return ResponseEntity.ok(applicantService.getApplicant(id));
    }

    @GetMapping("/Invoice")
    public ResponseEntity<List<ApplicantDTO>> getAllApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicantDTO> updateApplicant(@PathVariable Long id, @RequestBody ApplicantDTO applicantDTO) {
        return ResponseEntity.ok(applicantService.updateApplicant(id, applicantDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<ApplicantDTO> getByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.ok(applicantService.getByAccountNumber(accountNumber));
    }

    @GetMapping("/cifId/{cifId}")
    public ResponseEntity<ApplicantDTO> getByCifId(@PathVariable String cifId) {
        return ResponseEntity.ok(applicantService.getByCifId(cifId));
    }

    @GetMapping("/accountName/{accountName}")
    public ResponseEntity<ApplicantDTO> getByAccountName(@PathVariable String accountName) {
        return ResponseEntity.ok(applicantService.getByAccountName(accountName));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ApplicantDTO> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(applicantService.getByEmail(email));
    }

    @GetMapping("/nationalId/{nationalId}")
    public ResponseEntity<ApplicantDTO> getByNationalId(@PathVariable String nationalId) {
        return ResponseEntity.ok(applicantService.getByNationalId(nationalId));
    }

  
}
