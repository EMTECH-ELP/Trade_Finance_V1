package com.TradeFinance.collectionservice.tenor;

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
@Table (name = "_tenor-details")
public class TenorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tenorId;
    @Column(name = "tenor_type")
    private String tenorType;
    @Column(name = "tenor_description")
    private String tenorDescription;
    @Column(name = "tenor")
    private String tenor;
    @Column(name = "bill_amount")
    private String billAmount;
    @Column(name = "lodge_date")
    private Date lodgeDate;
    @Column(name = "acceptance_date")
    private Date acceptanceDate;
    @Column(name = "due_date")
    private Date dueDate;
    @OneToOne(mappedBy="tenorDetails")
    private Collection collection;
}
