package com.TradeFinance.collectionservice.tenor;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class TenorDto {
    private String tenorType;
    private String tenorDescription;
    private String tenor;
    private String billAmount;
    private Date lodgeDate;
    private Date acceptanceDate;
    private Date dueDate;
}
