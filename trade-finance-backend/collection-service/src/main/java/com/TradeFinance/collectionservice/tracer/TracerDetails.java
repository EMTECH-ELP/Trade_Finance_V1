package com.TradeFinance.collectionservice.tracer;

import com.TradeFinance.collectionservice.collection.Collection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracer_details")
public class TracerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tracerId;
    @Enumerated(EnumType.STRING)
    private TracerType tracerType;
    private String tracerFrequency;
    private String tracerMedium;
    private String tracerReceiverParty;
    private Date tracerStartDate;
    private String tracerStatus;
    @OneToOne(mappedBy="tracerDetails")
    private Collection collection;

}
