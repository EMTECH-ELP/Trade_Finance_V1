package com.TradeFinance.documentsservice.documents;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_documents")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentId;
    private String documentName;
    private String documentType;
    private LocalDateTime documentDate;
    private LocalDate documentExpiryDate;
    @Lob
    @Column(name = "documents")
    private byte[]  documents;

}
