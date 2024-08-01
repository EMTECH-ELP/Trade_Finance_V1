package com.TradeFinance.collectionservice.tracer;

import lombok.Data;

import java.util.Date;
@Data
public class TracerDto {
    private TracerType tracerType;
    private String tracerFrequency;
    private String tracerMedium;
    private String tracerReceiverParty;
    private Date tracerStartDate;
    private String tracerStatus;
}
