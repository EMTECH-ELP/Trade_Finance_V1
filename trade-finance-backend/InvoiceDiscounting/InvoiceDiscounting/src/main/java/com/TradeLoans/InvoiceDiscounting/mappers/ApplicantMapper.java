package com.TradeLoans.InvoiceDiscounting.mappers;

import com.TradeLoans.InvoiceDiscounting.dtos.ApplicantDTO;
import com.TradeLoans.InvoiceDiscounting.dtos.InvoiceDTO;
import com.TradeLoans.InvoiceDiscounting.model.Applicant;
import com.TradeLoans.InvoiceDiscounting.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicantMapper {
    public static ApplicantDTO toDTO(Applicant applicant) {
        List<InvoiceDTO> invoiceDTOs = applicant.getInvoices() != null ?
                applicant.getInvoices().stream()
                        .map(InvoiceMapper::toDTO)
                        .collect(Collectors.toList()) : new ArrayList<>();  // Handle null invoices
        return ApplicantDTO.builder()
                .accountNumber(applicant.getAccountNumber())
                .cifId(applicant.getCifId())
                .nationalId(applicant.getNationalId())
                .accountName(applicant.getAccountName())
                .currency(applicant.getCurrency())
                .email(applicant.getEmail())
                .phoneNumber(applicant.getPhoneNumber())
                .address(applicant.getAddress())
                .city(applicant.getCity())
                .postalCode(applicant.getPostalCode())
                .countryCode(applicant.getCountryCode())
                .country(applicant.getCountry())
                .invoices(invoiceDTOs)
                .build();
    }

    public static Applicant toEntity(ApplicantDTO dto) {
        Applicant applicant = Applicant.builder()
                .accountNumber(dto.getAccountNumber())
                .cifId(dto.getCifId())
                .nationalId(dto.getNationalId())
                .accountName(dto.getAccountName())
                .currency(dto.getCurrency())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .city(dto.getCity())
                .postalCode(dto.getPostalCode())
                .countryCode(dto.getCountryCode())
                .country(dto.getCountry())
                .build();

        if (dto.getInvoices() != null) {
            List<Invoice> invoices = dto.getInvoices().stream()
                    .map(invoiceDTO -> InvoiceMapper.toEntity(invoiceDTO, applicant))
                    .collect(Collectors.toList());
            applicant.setInvoices(invoices);
        } else {
            applicant.setInvoices(new ArrayList<>());  // Initialize to avoid null
        }

        return applicant;
    }
}
