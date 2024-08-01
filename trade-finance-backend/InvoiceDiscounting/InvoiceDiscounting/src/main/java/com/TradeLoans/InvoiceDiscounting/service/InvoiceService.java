package com.TradeLoans.InvoiceDiscounting.service;

import com.TradeLoans.InvoiceDiscounting.dtos.InvoiceDTO;
import com.TradeLoans.InvoiceDiscounting.mappers.InvoiceMapper;
import com.TradeLoans.InvoiceDiscounting.model.Applicant;
import com.TradeLoans.InvoiceDiscounting.model.Invoice;
import com.TradeLoans.InvoiceDiscounting.model.InvoiceStatus;
import com.TradeLoans.InvoiceDiscounting.repository.ApplicantRepository;
import com.TradeLoans.InvoiceDiscounting.repository.FundingRepository;
import com.TradeLoans.InvoiceDiscounting.repository.InvoiceRepository;
import com.TradeLoans.InvoiceDiscounting.utils.InvoiceNumberGenerator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private FundingRepository fundingRepository;

    public InvoiceDTO createInvoice(Long applicantId, InvoiceDTO invoiceDTO) {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        Invoice invoice = InvoiceMapper.toEntity(invoiceDTO, applicant);

        if (invoice.getInvoiceNumber() == null || invoice.getInvoiceNumber().isEmpty()) {
            invoice.setInvoiceNumber(InvoiceNumberGenerator.generate());
        }

        invoiceDTO.setStatus(InvoiceStatus.CREATED);

        return InvoiceMapper.toDTO(invoiceRepository.save(invoice));

    }

    public List<InvoiceDTO> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream()
                .map(InvoiceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public InvoiceDTO updateInvoice(Long id, InvoiceDTO invoiceDTO) {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        // Updating invoice properties
        existingInvoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        existingInvoice.setInvoiceAmount(invoiceDTO.getInvoiceAmount());
        existingInvoice.setDueDate(invoiceDTO.getDueDate());
        existingInvoice.setApplicantBusinessAddress(invoiceDTO.getApplicantBusinessAddress());
        existingInvoice.setApplicantBusinessName(invoiceDTO.getApplicantBusinessName());
        existingInvoice.setTermsAndCondition(invoiceDTO.getTermsAndCondition());
        existingInvoice.setBuyerName(invoiceDTO.getBuyerName());
        existingInvoice.setBuyerBusinessName(invoiceDTO.getBuyerBusinessName());
        existingInvoice.setBuyerCity(invoiceDTO.getBuyerCity());
        existingInvoice.setBuyerCountry(invoiceDTO.getBuyerCountry());
        existingInvoice.setBuyerEmailAddress(invoiceDTO.getBuyerEmailAddress());
        // No need to update status here, as it will transition automatically to APPROVED
        return InvoiceMapper.toDTO(invoiceRepository.save(existingInvoice));
    }

    public InvoiceDTO approveInvoiceById(Long id) {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        // Check if the invoice is in PENDING status
        if (existingInvoice.getStatus() != InvoiceStatus.PENDING) {
            throw new IllegalArgumentException("Invoice must be in PENDING status for approval");
        }
        // Set status to APPROVED
        existingInvoice.setStatus(InvoiceStatus.APPROVED);
        return InvoiceMapper.toDTO(invoiceRepository.save(existingInvoice));
    }

    public InvoiceDTO approveInvoiceByInvoiceNumber(String invoiceNumber) {
        Invoice existingInvoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
        // Check if the invoice is in PENDING status
        if (existingInvoice.getStatus() != InvoiceStatus.PENDING) {
            throw new IllegalArgumentException("Invoice must be in PENDING status for approval");
        }
        // Set status to APPROVED
        existingInvoice.setStatus(InvoiceStatus.APPROVED);
        return InvoiceMapper.toDTO(invoiceRepository.save(existingInvoice));
    }


    public void deleteInvoice(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new EntityNotFoundException("Invoice not found");
        }
        invoiceRepository.deleteById(id);
    }
    // Other service methods as needed
    public void deleteInvoiceByInvoiceNumber(String invoiceNumber) {
        Invoice existingInvoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Invoice with number " + invoiceNumber + " not found"));
        invoiceRepository.delete(existingInvoice);
    }

    public InvoiceDTO modifyInvoiceByInvoiceNumber(String invoiceNumber, InvoiceDTO invoiceDTO) {
        Invoice existingInvoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Invoice with number " + invoiceNumber + " not found"));

        // Update the existing invoice properties
        existingInvoice.setInvoiceDate(invoiceDTO.getInvoiceDate());
        existingInvoice.setInvoiceAmount(invoiceDTO.getInvoiceAmount());
        existingInvoice.setDueDate(invoiceDTO.getDueDate());
        existingInvoice.setApplicantBusinessAddress(invoiceDTO.getApplicantBusinessAddress());
        existingInvoice.setApplicantBusinessName(invoiceDTO.getApplicantBusinessName());
        existingInvoice.setTermsAndCondition(invoiceDTO.getTermsAndCondition());
        existingInvoice.setBuyerName(invoiceDTO.getBuyerName());
        existingInvoice.setBuyerBusinessName(invoiceDTO.getBuyerBusinessName());
        existingInvoice.setBuyerCity(invoiceDTO.getBuyerCity());
        existingInvoice.setBuyerCountry(invoiceDTO.getBuyerCountry());
        existingInvoice.setBuyerEmailAddress(invoiceDTO.getBuyerEmailAddress());

        return InvoiceMapper.toDTO(invoiceRepository.save(existingInvoice));
    }



}
