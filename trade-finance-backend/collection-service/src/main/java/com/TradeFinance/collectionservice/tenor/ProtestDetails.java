package com.TradeFinance.collectionservice.tenor;

import com.TradeFinance.collectionservice.collection.Collection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "protest_details")
public class ProtestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long protestId;
    private String protestDate;
    private String reason;
    private String remarks;
    @OneToOne(mappedBy="protestDetails")
    private Collection collection;
}



