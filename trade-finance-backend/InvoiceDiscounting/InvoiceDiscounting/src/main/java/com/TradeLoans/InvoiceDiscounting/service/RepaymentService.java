package com.TradeLoans.InvoiceDiscounting.service;
import com.TradeLoans.InvoiceDiscounting.dtos.RepaymentDTO;
import com.TradeLoans.InvoiceDiscounting.model.Invoice;
import com.TradeLoans.InvoiceDiscounting.model.Repayment;
import com.TradeLoans.InvoiceDiscounting.repository.InvoiceRepository;
import com.TradeLoans.InvoiceDiscounting.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepaymentService {

    @Autowired
    private RepaymentRepository repaymentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<RepaymentDTO> getAllRepayments() {
        return repaymentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RepaymentDTO getRepaymentById(Long id) {
        return repaymentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public RepaymentDTO createRepayment(RepaymentDTO repaymentDTO) {
        Invoice invoice = invoiceRepository.findById(repaymentDTO.getInvoiceId())
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        Repayment repayment = convertToEntity(repaymentDTO);
        repayment.setInvoice(invoice);
        return convertToDTO(repaymentRepository.save(repayment));
    }

    public RepaymentDTO updateRepayment(Long id, RepaymentDTO repaymentDTO) {
        Repayment existingRepayment = repaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repayment not found"));
        existingRepayment.setDebtorNameId(repaymentDTO.getDebtorNameId());
        existingRepayment.setOriginalAmount(repaymentDTO.getOriginalAmount());
        existingRepayment.setRepaymentAmount(repaymentDTO.getRepaymentAmount());
        existingRepayment.setOutstandingAmount(repaymentDTO.getOutstandingAmount());
        existingRepayment.setRepaymentDate(repaymentDTO.getRepaymentDate());
        existingRepayment.setActualRepaymentDate(repaymentDTO.getActualRepaymentDate());
        existingRepayment.setStatus(Repayment.RepaymentStatus.valueOf(repaymentDTO.getStatus()));
        existingRepayment.setPenaltyAmount(repaymentDTO.getPenaltyAmount());
        return convertToDTO(repaymentRepository.save(existingRepayment));
    }

    public void deleteRepayment(Long id) {
        repaymentRepository.deleteById(id);
    }

    private RepaymentDTO convertToDTO(Repayment repayment) {
        return RepaymentDTO.builder()
                .repaymentId(repayment.getRepaymentId())
                .invoiceId(repayment.getInvoice().getId())
                .debtorNameId(repayment.getDebtorNameId())
                .originalAmount(repayment.getOriginalAmount())
                .repaymentAmount(repayment.getRepaymentAmount())
                .outstandingAmount(repayment.getOutstandingAmount())
                .repaymentDate(repayment.getRepaymentDate())
                .actualRepaymentDate(repayment.getActualRepaymentDate())
                .status(repayment.getStatus().name())
                .penaltyAmount(repayment.getPenaltyAmount())
                .build();
    }

    private Repayment convertToEntity(RepaymentDTO repaymentDTO) {
        return Repayment.builder()
                .repaymentId(repaymentDTO.getRepaymentId())
                .debtorNameId(repaymentDTO.getDebtorNameId())
                .originalAmount(repaymentDTO.getOriginalAmount())
                .repaymentAmount(repaymentDTO.getRepaymentAmount())
                .outstandingAmount(repaymentDTO.getOutstandingAmount())
                .repaymentDate(repaymentDTO.getRepaymentDate())
                .actualRepaymentDate(repaymentDTO.getActualRepaymentDate())
                .status(Repayment.RepaymentStatus.valueOf(repaymentDTO.getStatus()))
                .penaltyAmount(repaymentDTO.getPenaltyAmount())
                .build();
    }
}