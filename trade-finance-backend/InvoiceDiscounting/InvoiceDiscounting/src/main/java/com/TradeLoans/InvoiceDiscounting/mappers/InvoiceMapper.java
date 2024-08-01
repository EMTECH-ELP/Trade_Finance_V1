package com.TradeLoans.InvoiceDiscounting.mappers;

import com.TradeLoans.InvoiceDiscounting.dtos.FundingDTO;
import com.TradeLoans.InvoiceDiscounting.dtos.InvoiceDTO;
import com.TradeLoans.InvoiceDiscounting.model.Applicant;
import com.TradeLoans.InvoiceDiscounting.model.Funding;
import com.TradeLoans.InvoiceDiscounting.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {
    public static InvoiceDTO toDTO(Invoice invoice) {
        return InvoiceDTO.builder()
                .invoiceNumber(invoice.getInvoiceNumber())
                .invoiceDate(invoice.getInvoiceDate())
                .invoiceAmount(invoice.getInvoiceAmount())
                .dueDate(invoice.getDueDate())
                .applicantBusinessAddress(invoice.getApplicantBusinessAddress())
                .applicantBusinessName(invoice.getApplicantBusinessName())
                .termsAndCondition(invoice.getTermsAndCondition())
                .buyerName(invoice.getBuyerName())
                .buyerBusinessName(invoice.getBuyerBusinessName())
                .buyerCity(invoice.getBuyerCity())
                .buyerCountry(invoice.getBuyerCountry())
                .buyerEmailAddress(invoice.getBuyerEmailAddress())
                .status(invoice.getStatus())
                .build();
    }

    public static Invoice toEntity(InvoiceDTO dto, Applicant applicant) {
        return Invoice.builder()
                .invoiceNumber(dto.getInvoiceNumber())
                .invoiceDate(dto.getInvoiceDate())
                .invoiceAmount(dto.getInvoiceAmount())
                .dueDate(dto.getDueDate())
                .applicantBusinessAddress(dto.getApplicantBusinessAddress())
                .applicantBusinessName(dto.getApplicantBusinessName())
                .termsAndCondition(dto.getTermsAndCondition())
                .buyerName(dto.getBuyerName())
                .buyerBusinessName(dto.getBuyerBusinessName())
                .buyerCity(dto.getBuyerCity())
                .buyerCountry(dto.getBuyerCountry())
                .buyerEmailAddress(dto.getBuyerEmailAddress())
                .status(dto.getStatus())
                .applicant(applicant)
                .build();
    }
}


