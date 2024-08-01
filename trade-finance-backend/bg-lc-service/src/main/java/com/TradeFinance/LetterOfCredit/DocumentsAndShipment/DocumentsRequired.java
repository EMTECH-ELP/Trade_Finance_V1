package com.TradeFinance.LetterOfCredit.DocumentsAndShipment;

import com.TradeFinance.LetterOfCredit.LetterOfCredit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "documents_tbl")
public class DocumentsRequired  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentName1;
    private String documentDescription1;
    private String documentName2;
    private String documentDescription2;
    private String documentName3;
    private String documentDescription3;
    private String documentName4;
    private String documentDescription4;
    private String documentName5;
    private String documentDescription5;
    private String documentName6;
    private String documentDescription6;
    private String documentName7;
    private String documentDescription7;
    private String documentName8;
    private String documentDescription8;
    private String documentName9;
    private String documentDescription9;
    @OneToOne(mappedBy = "documentsRequired")
    @JsonBackReference
    private LetterOfCredit letterOfCredit;
}