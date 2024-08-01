package com.TradeLoans.InvoiceDiscounting.service;

import com.TradeLoans.InvoiceDiscounting.dtos.ApplicantDTO;
import com.TradeLoans.InvoiceDiscounting.mappers.ApplicantMapper;
import com.TradeLoans.InvoiceDiscounting.model.Applicant;
import com.TradeLoans.InvoiceDiscounting.model.InvoiceStatus;
import com.TradeLoans.InvoiceDiscounting.repository.ApplicantRepository;
import com.TradeLoans.InvoiceDiscounting.utils.InvoiceNumberGenerator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public ApplicantDTO createApplicant(ApplicantDTO applicantDTO) {
        Applicant applicant = ApplicantMapper.toEntity(applicantDTO);

        if (applicant.getInvoices() != null) {
            applicant.getInvoices().forEach(invoice -> {
                if (invoice.getInvoiceNumber() == null || invoice.getInvoiceNumber().isEmpty()) {
                    invoice.setInvoiceNumber(InvoiceNumberGenerator.generate());
                }
                invoice.setApplicant(applicant);
            });
        } else {
            applicant.setInvoices(new ArrayList<>());
        }

        return ApplicantMapper.toDTO(applicantRepository.save(applicant));
    }

    public ApplicantDTO getApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return ApplicantMapper.toDTO(applicant);
    }

    public List<ApplicantDTO> getAllApplicants() {
        return applicantRepository.findAll().stream()
                .map(ApplicantMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ApplicantDTO updateApplicant(Long id, ApplicantDTO applicantDTO) {
        Applicant existingApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        Applicant updatedApplicant = ApplicantMapper.toEntity(applicantDTO);
        updatedApplicant.setId(existingApplicant.getId());  // Preserve the original ID
        return ApplicantMapper.toDTO(applicantRepository.save(updatedApplicant));
    }

    public void deleteApplicant(Long id) {
        applicantRepository.deleteById(id);
    }

    public ApplicantDTO getByAccountNumber(String accountNumber) {
        Applicant applicant = applicantRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Applicant with account number " + accountNumber + " not found"));

        // Change status from CREATED to PENDING for all invoices
        applicant.getInvoices().forEach(invoice -> {
            if (invoice.getStatus() == InvoiceStatus.CREATED) {
                invoice.setStatus(InvoiceStatus.PENDING);
            }
        });

        return ApplicantMapper.toDTO(applicantRepository.save(applicant));
    }


    public ApplicantDTO getByCifId(String cifId) {
        Applicant applicant = applicantRepository.findByCifId(cifId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return ApplicantMapper.toDTO(applicant);
    }

    public ApplicantDTO getByAccountName(String accountName) {
        Applicant applicant = applicantRepository.findByAccountName(accountName)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return ApplicantMapper.toDTO(applicant);
    }

    public ApplicantDTO getByEmail(String email) {
        Applicant applicant = applicantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return ApplicantMapper.toDTO(applicant);
    }

    public ApplicantDTO getByNationalId(String nationalId) {
        Applicant applicant = applicantRepository.findByNationalId(nationalId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        return ApplicantMapper.toDTO(applicant);
    }




}
