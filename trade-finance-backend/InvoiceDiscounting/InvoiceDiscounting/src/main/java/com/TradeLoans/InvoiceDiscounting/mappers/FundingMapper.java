package com.TradeLoans.InvoiceDiscounting.mappers;

import com.TradeLoans.InvoiceDiscounting.dtos.FundingDTO;
import com.TradeLoans.InvoiceDiscounting.model.Funding;
import com.TradeLoans.InvoiceDiscounting.model.Invoice;
public class FundingMapper {
    public static FundingDTO toDTO(Funding funding) {
        return FundingDTO.builder()
                .creditLimit(funding.getCreditLimit())
                .fundingAmount(funding.getFundingAmount())
                .creditAccount(funding.getCreditAccount())
                .disbursalDate(funding.getDisbursalDate())
                .repaymentDate(funding.getRepaymentDate())
                .fundingRepaymentStatus(funding.isFundingRepaymentStatus())
                .status(funding.getStatus())
                .discountRate(funding.getDiscountRate())
                .build();
    }

    public static Funding toEntity(FundingDTO dto, Invoice invoice) {
        return Funding.builder()
                .creditLimit(dto.getCreditLimit())
                .fundingAmount(dto.getFundingAmount())
                .creditAccount(dto.getCreditAccount())
                .disbursalDate(dto.getDisbursalDate())
                .repaymentDate(dto.getRepaymentDate())
                .fundingRepaymentStatus(dto.isFundingRepaymentStatus())
                .status(dto.getStatus())
                .invoice(invoice)
                .discountRate(dto.getDiscountRate())
                .build();
    }
}
