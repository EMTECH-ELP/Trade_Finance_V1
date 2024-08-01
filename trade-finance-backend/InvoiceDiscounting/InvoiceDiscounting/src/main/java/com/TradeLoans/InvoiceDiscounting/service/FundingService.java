package com.TradeLoans.InvoiceDiscounting.service;


import com.TradeLoans.InvoiceDiscounting.dtos.FundingDTO;
import com.TradeLoans.InvoiceDiscounting.dtos.FundingDetailsDTO;
import com.TradeLoans.InvoiceDiscounting.mappers.FundingMapper;
import com.TradeLoans.InvoiceDiscounting.model.Funding;
import com.TradeLoans.InvoiceDiscounting.model.Invoice;
import com.TradeLoans.InvoiceDiscounting.repository.FundingRepository;
import com.TradeLoans.InvoiceDiscounting.repository.InvoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FundingService {

    @Autowired
    private FundingRepository fundingRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Transactional
    public FundingDTO calculateFundingAmount(String invoiceNumber, BigDecimal discountRate, BigDecimal creditLimit) {
        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));

        // Perform calculation to determine funding amount based on provided factors
        BigDecimal discountedAmount = invoice.getInvoiceAmount().multiply(discountRate);
        BigDecimal fundingAmount = discountedAmount.subtract(creditLimit);
        return FundingDTO.builder()
                .fundingAmount(fundingAmount)
                .creditLimit(creditLimit)
                .discountRate(discountRate)
                .status(Funding.FundingStatus.PENDING)
                .build();
    }

    @Transactional
    public FundingDTO createFunding(FundingDTO fundingDTO, String invoiceNumber) {
        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));

        Funding funding = FundingMapper.toEntity(fundingDTO, invoice);
        funding.setStatus(Funding.FundingStatus.PENDING);
        funding = fundingRepository.save(funding);

        return FundingMapper.toDTO(funding);
    }

    @Transactional
    public FundingDTO updateFunding(Long id, FundingDTO fundingDTO) {
        Funding existingFunding = fundingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funding not found"));

        Funding updatedFunding = FundingMapper.toEntity(fundingDTO, existingFunding.getInvoice());
        updatedFunding.setId(existingFunding.getId());

        return FundingMapper.toDTO(fundingRepository.save(updatedFunding));
    }

    @Transactional
    public FundingDTO approveFunding(Long id) {
        Funding existingFunding = fundingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funding not found"));
        if (existingFunding.getStatus() != Funding.FundingStatus.PENDING) {
            throw new IllegalArgumentException("Funding must be in PENDING status for approval");
        }
        existingFunding.setStatus(Funding.FundingStatus.APPROVED);
        return FundingMapper.toDTO(fundingRepository.save(existingFunding));
    }

    @Transactional
    public FundingDTO approveFundingByInvoiceNumber(String invoiceNumber) {
        Funding existingFunding = fundingRepository.findByInvoiceInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Funding not found"));
        if (existingFunding.getStatus() != Funding.FundingStatus.PENDING) {
            throw new IllegalArgumentException("Funding must be in PENDING status for approval");
        }
        existingFunding.setStatus(Funding.FundingStatus.APPROVED);
        return FundingMapper.toDTO(fundingRepository.save(existingFunding));
    }

    public Optional<FundingDTO> getFunding(Long id) {
        return fundingRepository.findById(id).map(FundingMapper::toDTO);
    }

    public Optional<FundingDTO> getFundingByInvoiceNumber(String invoiceNumber) {
        return fundingRepository.findByInvoiceInvoiceNumber(invoiceNumber).map(FundingMapper::toDTO);
    }

    @Transactional
    public void deleteFunding(Long id) {
        fundingRepository.deleteById(id);
    }

    public List<FundingDTO> getAllFundings() {
        return fundingRepository.findAll().stream().map(FundingMapper::toDTO).collect(Collectors.toList());
    }

    public FundingDetailsDTO getFundingDetailsByInvoiceNumber(String invoiceNumber) {
        Invoice invoice = invoiceRepository.findByInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));

        Funding funding = fundingRepository.findByInvoiceInvoiceNumber(invoiceNumber)
                .orElseThrow(() -> new EntityNotFoundException("Funding not found"));

        return new FundingDetailsDTO(
                invoice,
                FundingMapper.toDTO(funding)
        );
    }
}

