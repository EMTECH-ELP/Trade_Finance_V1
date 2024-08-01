package com.TradeFinance.bankguarantee.mapper;

import com.TradeFinance.bankguarantee.dto.SecurityDetailsDto;
import com.TradeFinance.bankguarantee.entity.SecurityDetails;

public class SecurityDetailsMapper {

    // Method to convert SecurityDetails to SecurityDetailsDto
    public static SecurityDetailsDto toDto(SecurityDetails securityDetails) {
        if (securityDetails == null) {
            return null;
        }

        SecurityDetailsDto dto = new SecurityDetailsDto();
        dto.setSecurityType(securityDetails.getSecurityType());
        dto.setSecurityAmount(securityDetails.getSecurityAmount());
        dto.setSecurityCurrency(securityDetails.getSecurityCurrency());
        dto.setSecurityChargeAccount(securityDetails.getSecurityChargeAccount());
        dto.setDescription(securityDetails.getDescription());
        dto.setIssuer(securityDetails.getIssuer());
        dto.setMaturityDate(securityDetails.getMaturityDate());
        dto.setSecurityRating(securityDetails.getSecurityRating());

        return dto;
    }

    // Method to convert SecurityDetailsDto to SecurityDetails
    public static SecurityDetails toEntity(SecurityDetailsDto dto) {
        if (dto == null) {
            return null;
        }

        SecurityDetails entity = new SecurityDetails();
        entity.setSecurityType(dto.getSecurityType());
        entity.setSecurityAmount(dto.getSecurityAmount());
        entity.setSecurityCurrency(dto.getSecurityCurrency());
        entity.setSecurityChargeAccount(dto.getSecurityChargeAccount());
        entity.setDescription(dto.getDescription());
        entity.setIssuer(dto.getIssuer());
        entity.setMaturityDate(dto.getMaturityDate());
        entity.setSecurityRating(dto.getSecurityRating());

        return entity;
    }
}
