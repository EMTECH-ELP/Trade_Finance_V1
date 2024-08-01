package com.TradeFinance.bankguarantee.mapper;

import com.TradeFinance.bankguarantee.dto.CounterGuaranteeDto;
import com.TradeFinance.bankguarantee.entity.CounterGuaranteeDetails;

//@Component
public class CounterGuaranteeMapper {

    public CounterGuaranteeDto entityToDto(CounterGuaranteeDetails counterGuaranteeDetails) {
        CounterGuaranteeDto counterGuaranteeDto = new CounterGuaranteeDto();
        counterGuaranteeDto.setGuaranteeNo(counterGuaranteeDetails.getGuaranteeNo());
        counterGuaranteeDto.setCounterGuaranteeAmount(counterGuaranteeDetails.getCounterGuaranteeAmount());
        counterGuaranteeDto.setExpiryDate(counterGuaranteeDetails.getExpiryDate());
        counterGuaranteeDto.setClaimExpiryDate(counterGuaranteeDetails.getClaimExpiryDate());
        counterGuaranteeDto.setSwiftCode(counterGuaranteeDetails.getSwiftCode());
        counterGuaranteeDto.setBranchCode(counterGuaranteeDetails.getBranchCode());
        counterGuaranteeDto.setRemarks(counterGuaranteeDetails.getRemarks());
        counterGuaranteeDto.setCounterGuaranteeStatus(counterGuaranteeDetails.getCounterGuaranteeStatus());
        return counterGuaranteeDto;
    }

    public CounterGuaranteeDetails dtoToEntity(CounterGuaranteeDto counterGuaranteeDto) {
        CounterGuaranteeDetails counterGuaranteeDetails = new CounterGuaranteeDetails();
        counterGuaranteeDetails.setGuaranteeNo(counterGuaranteeDto.getGuaranteeNo());
        counterGuaranteeDetails.setCounterGuaranteeAmount(counterGuaranteeDto.getCounterGuaranteeAmount());
        counterGuaranteeDetails.setExpiryDate(counterGuaranteeDto.getExpiryDate());
        counterGuaranteeDetails.setClaimExpiryDate(counterGuaranteeDto.getClaimExpiryDate());
        counterGuaranteeDetails.setSwiftCode(counterGuaranteeDto.getSwiftCode());
        counterGuaranteeDetails.setBranchCode(counterGuaranteeDto.getBranchCode());
        counterGuaranteeDetails.setRemarks(counterGuaranteeDto.getRemarks());
        counterGuaranteeDetails.setCounterGuaranteeStatus(counterGuaranteeDto.getCounterGuaranteeStatus());
        return counterGuaranteeDetails;
    }
}